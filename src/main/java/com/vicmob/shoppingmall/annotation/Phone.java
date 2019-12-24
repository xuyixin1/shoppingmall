package com.vicmob.shoppingmall.annotation;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.lang.annotation.*;

/**
 * @author  xuyx
 */

@Documented
@Constraint(
        validatedBy = {}
)
@SupportedValidationTarget({ValidationTarget.ANNOTATED_ELEMENT})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp = "^1[3456789]\\d{9}$")
@ReportAsSingleViolation
public @interface Phone {
    @OverridesAttribute(
            constraint = Pattern.class,
            name = "regexp"
    )
    String regexp() default "^1[3456789]\\d{9}$";


    String message() default "{phone 验证失败}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
