package com.kin.big_events.anno;

import com.kin.big_events.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented//元注解，加入文档
@Target({ElementType.FIELD})//元注解，运用位置
@Retention(RetentionPolicy.RUNTIME)//元注解，运行阶段
@Constraint(validatedBy = {StateValidation.class})//由谁提供校验规则,指定提供校验规则的类


public @interface State {
    //提供校验后的失败信息
    String message() default "State的参数只能是“草稿”或“已发布”";
    //指定分组
    Class<?>[] groups() default {};
    //负载，获取到State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
