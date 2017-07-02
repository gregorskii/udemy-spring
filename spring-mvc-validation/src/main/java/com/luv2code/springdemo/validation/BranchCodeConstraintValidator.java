package com.luv2code.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BranchCodeConstraintValidator
    implements ConstraintValidator<BranchCode, String> {

    private String branchPrefix;

    @Override
    public void initialize(BranchCode constraint) {
        branchPrefix = constraint.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || value.startsWith(branchPrefix);
    }
}
