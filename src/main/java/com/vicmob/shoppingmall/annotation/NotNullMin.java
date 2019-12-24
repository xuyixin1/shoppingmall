package com.vicmob.shoppingmall.annotation;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {}
)
@SupportedValidationTarget({ValidationTarget.ANNOTATED_ELEMENT})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@NotNull
@Min(1)
@ReportAsSingleViolation
public @interface NotNullMin {
    @OverridesAttribute(
            constraint = Min.class,
            name = "value"
    )
    long value() default 1;

    String message() default "{javax.validation.constraints.Min.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
