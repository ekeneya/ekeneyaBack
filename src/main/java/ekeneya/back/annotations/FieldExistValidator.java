package ekeneya.back.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import ekeneya.back.models.entities.TypeStructure;
import ekeneya.back.services.IFieldValueExist;
import ekeneya.back.services.ITypeStructureService;


public class FieldExistValidator implements ConstraintValidator<FieldExist, TypeStructure> {

	@Autowired
	private ApplicationContext applicationContext;

	private String field;
	
	private IFieldValueExist service;
	
	@Autowired
	private ITypeStructureService typeService;
	
	@Override
	public void initialize(FieldExist constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(TypeStructure type, ConstraintValidatorContext arg1) {
		if(typeService==null){
			return true;
		}
		if (type == null || type.getCode() == null) {
			return false;
		}
		return false;
	}

}
