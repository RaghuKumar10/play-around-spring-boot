package learn.springboot.config.security.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UserCredentials implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -462940462975004790L;
	
	private String username;
	private String password;
	
	public UserCredentials(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
}
