package learn.springboot.user.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UserDto {
	private long id;
	
	@NotNull @NotEmpty
	private String firstName;
	private String lastName;
	private String userName;
	
	@NotNull @NotEmpty
	private String password;
	
	@NotNull @NotEmpty
	private String emailId;
}
