package learn.springboot.validation.entity;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ValidationDescrption {
	private List<CustomFieldError> fieldErrors;
}
