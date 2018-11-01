package learn.springboot.exception.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ErrorDescription {
	private int status;
	private String error;
	
	public ErrorDescription(int status, String error) {
		this.status = status;
		this.error = error;
	}
}
