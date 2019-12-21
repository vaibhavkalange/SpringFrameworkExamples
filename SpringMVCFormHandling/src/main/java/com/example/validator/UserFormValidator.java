package com.example.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.model.User;

@Component
public class UserFormValidator implements Validator {
	
	@Autowired
	private EmailValidator emailValidator;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.userForm.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty.userForm.country");
		
		if(!emailValidator.valid(user.getEmail())){
			errors.rejectValue("email","Pattern.userForm.email");
		}
		if(user.getCountry().equalsIgnoreCase("none")){
			errors.rejectValue("country", "NotEmpty.userForm.country");
		}
		if (user.getFrameworks() == null || user.getFrameworks().size() < 2) {
			errors.rejectValue("frameworks", "Valid.userForm.frameworks");
		}

		if (user.getSkills() == null || user.getSkills().size() < 3) {
			errors.rejectValue("skills", "Valid.userForm.skills");
		}
	}
}
