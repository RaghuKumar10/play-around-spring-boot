package learn.springboot.validation.handler;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import learn.springboot.validation.entity.FieldMatch;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>{
	
	private String field;
    private String fieldMatch;
    private String message;
	@Override
    public void initialize(final FieldMatch constraintAnnotation)
    {
		field = constraintAnnotation.first();
		fieldMatch = constraintAnnotation.second();
		message = constraintAnnotation.message();
    }
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean status = false;
		try
        {
            final Object firstObj = BeanUtils.getProperty(value, field);
            final Object secondObj = BeanUtils.getProperty(value, fieldMatch);

            status = (firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj));
        }
        catch (final Exception ignore)
        {
            // ignore
        }
		if(!status) {
			context.buildConstraintViolationWithTemplate(message)
			.addPropertyNode(field).addConstraintViolation()
			.disableDefaultConstraintViolation();
		}
        return status;
	}

}