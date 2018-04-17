package ekeneya.back.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;

import ekeneya.back.exceptions.ApiException;
import ekeneya.back.exceptions.ApiExceptions;

@Component
public class EntityValidator<E> {

	/***
	 * 
	 * @param e
	 * @return
	 */
	public ApiExceptions validateEntite(E e) {
		final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		final Validator validator = factory.getValidator();
		Set<ConstraintViolation<E>> constraintViolations = validator.validate(e);
		ApiExceptions apiExceptions = new ApiExceptions();
		for (ConstraintViolation<E> constraintViolation : constraintViolations) {
			apiExceptions.addException(new ApiException(constraintViolation.getPropertyPath().toString(),
					constraintViolation.getMessage()));
		}
		return apiExceptions;
	}
}
