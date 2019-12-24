package com.vicmob.shoppingmall.annotation;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
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
@DecimalMin("0.01")
@DecimalMax("999.99")
@Digits(integer = 3,fraction = 2)
@ReportAsSingleViolation
public @interface Number {
    @OverridesAttribute(
            constraint = DecimalMin.class,
            name = "value"
    )
    String min() default "0.01";

    @OverridesAttribute(
            constraint = DecimalMax.class,
            name = "value"
    )
    String max() default "999.99";

    @OverridesAttribute(
            constraint = Digits.class,
            name = "integer"
    )
    int integer() default 3;

    @OverridesAttribute(
            constraint = Digits.class,
            name = "fraction"
    )
    int fraction() default 2;

    String message() default "{org.hibernate.validator.constraints.Range.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
