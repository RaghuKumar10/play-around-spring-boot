package learn.springboot.config.security.model;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class JwtAuthenticationResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2549482838452975509L;
	private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }
}
