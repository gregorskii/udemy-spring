package com.luv2code.springdemo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Constraint(validatedBy = BranchCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface BranchCode {

    public String value() default "USA";

    public String message() default "Must start with USA";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
