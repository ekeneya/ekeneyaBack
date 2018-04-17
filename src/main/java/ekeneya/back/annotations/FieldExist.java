package ekeneya.back.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ekeneya.back.services.IFieldValueExist;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldExistValidator.class)
@Component
public @interface FieldExist {
	
	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	Class<? extends IFieldValueExist> service();
	
	String field();
}
