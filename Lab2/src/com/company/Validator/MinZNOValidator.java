package com.company.Validator;

import com.company.Validator.MinZNO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinZNOValidator implements ConstraintValidator<MinZNO, Integer> {

    private int annotationMin;

    @Override
    public void initialize(MinZNO age) {
        this.annotationMin = age.value();
    }


    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if(integer>=annotationMin)
            return true;
        else {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("must be more than" + annotationMin)
                    .addConstraintViolation();
            return false;
        }
    }
}

