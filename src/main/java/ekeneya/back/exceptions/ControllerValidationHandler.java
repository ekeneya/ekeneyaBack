package ekeneya.back.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;


@ControllerAdvice
public class ControllerValidationHandler {
	
	private final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private MessageSource msgSource;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	@ResponseBody
	public Map<String, List<String>> processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		Locale currentLocale = LocaleContextHolder.getLocale();

		Map<String, List<String>> errors = new HashMap<>();
		for (FieldError error : result.getFieldErrors()) {
			String msg = msgSource.getMessage(error.getDefaultMessage(), null, currentLocale);
			String field = error.getField();
			if (errors.containsKey(field)) {
				errors.get(field).add(msg);
			} else {
				List<String> list = new ArrayList<>();
				list.add(msg);
				errors.put(field, list);
			}
			logger.info(field +" => "+msg);
		}

		return errors;
	}
	

	@ExceptionHandler(ApiExceptions.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	@ResponseBody
	public Map<String, List<String>> handleApiExceptions(ApiExceptions ex) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		
		Map<String, List<String>> errors = new HashMap<>();

		for (ApiException apiException : ex.getExceptions()) {
			String msg = msgSource.getMessage(apiException.getMessageKey(), null, currentLocale);
			String field = apiException.getField();
			if (errors.containsKey(field)) {
				errors.get(field).add(msg);
			} else {
				List<String> list = new ArrayList<>();
				list.add(msg);
				errors.put(field, list);
			}
			logger.info(field +" => "+msg);
		}

		return errors;
	}
	
	@ExceptionHandler(ApiException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	@ResponseBody
	public Map<String, String> handleApiException(ApiException apiException) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		
		Map<String, String> error = new HashMap<>();

		String msg = msgSource.getMessage(apiException.getMessageKey(), null, currentLocale);
		
		String field = apiException.getField();
		
		error.put(field, msg);
		
		logger.info(field +" => "+msg);
		
		return error;
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Map<String, String> handleInvalidFormatException(InvalidFormatException e) {
		
		Map<String, String> error = new HashMap<>();

		error.put("parse", "Objet mal formatté");
		
		logger.info(e.getMessage());
		
		return error;
	}
}
