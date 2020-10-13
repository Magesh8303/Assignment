package com.demo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.model.Person;

@Component
public class PersonValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Person.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (errors.getErrorCount() == 0) {

			Person person = (Person) target;
			if (person.getFirstName().equals(null) || person.getFirstName().equals("")) {

				errors.reject("100", "FirstName should not be empty");

			}
		}

	}

}
