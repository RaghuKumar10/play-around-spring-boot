package learn.springboot.validation.handler;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import learn.springboot.user.entity.User;
import learn.springboot.user.repository.UserRepository;
import learn.springboot.validation.entity.DoesEmailIdExist;

public class UserByEmailIdValidator implements ConstraintValidator<DoesEmailIdExist, String> {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean status = false;
		if(value == null || value.trim().length() <= 0) {
			status = true;
		}else {
			User userByEmailId = userRepo.findByEmailId(value);
			status = !(userByEmailId != null && value.equalsIgnoreCase(userByEmailId.getEmailId()));
		}
		return status;
	}

}