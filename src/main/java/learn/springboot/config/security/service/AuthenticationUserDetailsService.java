package learn.springboot.config.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import learn.springboot.config.security.jwt.JwtUserFactory;
import learn.springboot.user.entity.User;
import learn.springboot.user.repository.UserRepository;

@Component
public class AuthenticationUserDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	@Autowired
    public AuthenticationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByEmailId(userName);
		if(null == user){
			throw new UsernameNotFoundException("No user present with username: "+userName);
		}else{
			return JwtUserFactory.create(user);
		}
	}

}
