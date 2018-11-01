package learn.springboot.config.security.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UserCredentials {
	private String username;
	private String password;
}
