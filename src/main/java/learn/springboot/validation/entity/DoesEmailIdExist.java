package learn.springboot.validation.entity;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import learn.springboot.validation.handler.UserByEmailIdValidator;

@Documented
@Constraint(validatedBy = UserByEmailIdValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DoesEmailIdExist {
	String message() default "Email Id Is Already Used";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}