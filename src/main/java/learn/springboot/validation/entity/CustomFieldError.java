package learn.springboot.validation.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CustomFieldError {
	private String fieldName;
	private String description;
	
	public CustomFieldError(String fieldName, String description){
		this.fieldName = fieldName;
		this.description = description;
	}
}
