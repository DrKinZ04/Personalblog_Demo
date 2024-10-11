package com.kin.big_events.service.impl;

import com.kin.big_events.mapper.UserMapper;
import com.kin.big_events.pojo.User;
import com.kin.big_events.service.UserService;
import com.kin.big_events.utils.Md5Util;
import com.kin.big_events.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(String username, String password) {
        String md5String = Md5Util.getMD5String(password);
        userMapper.add(username,md5String);
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl,userId);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        userMapper.updatePwd(Md5Util.getMD5String(newPwd),userId);
    }
}
