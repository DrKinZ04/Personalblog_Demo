package com.kin.big_events.validation;

import com.kin.big_events.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State, String> {
    /**
     * @param value                      将来要校验的数据
     * @param constraintValidatorContext
     * @return false 表示校验不通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        //提供校验规则
        if (value == null) {
            return false;
        }
        if (value.equals("草稿") || value.equals("已发布")) {
            return true;
        }
        return false;
    }
}
