package learn.springboot;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderMainFunc {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("password"));
	}

}
