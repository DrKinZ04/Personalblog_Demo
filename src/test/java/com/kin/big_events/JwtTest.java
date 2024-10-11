package com.kin.big_events;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

//JWT测试用例
public class JwtTest {

    //JWT组成：header、载荷、签名
    //token生成
    @Test
    public void testGenerateToken() {

        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("id", "1");
        claims.put("username", "张三");
        String token = JWT.create()
                .withClaim("user",claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))//添加过期时间，此处过期时间为12小时
                .sign(Algorithm.HMAC256("zhang"));//指定算法,配置密钥
        System.out.println(token);
    }

    //token验证
    @Test
    public void testParseToken() {
        String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJ1c2VyIjp7ImlkIjoiMSIsInVzZXJuYW1lIjoi5byg5LiJIn0sImV4cCI6MTcyODI0MDg4Nn0." +
                "fjF7xdgTneE_J3cNfdal1eBMaXxLPX_suomDfRyxC60";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("zhang")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);//验证token，生成一个解析后的JWT对象

        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }

}
