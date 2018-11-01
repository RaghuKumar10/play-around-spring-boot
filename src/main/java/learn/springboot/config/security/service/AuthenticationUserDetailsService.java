package learn.springboot.config.security.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import learn.springboot.config.security.model.SecuredUserDetails;
import learn.springboot.user.entity.User;
import learn.springboot.user.repository.RolesRepository;
import learn.springboot.user.repository.UserRepository;

@Component
public class AuthenticationUserDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;
	private final RolesRepository rolesRepository;
	
	@Autowired
    public AuthenticationUserDetailsService(UserRepository userRepository,RolesRepository rolesRepository) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
    }
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByEmailId(userName);
		if(null == user){
			throw new UsernameNotFoundException("No user present with username: "+userName);
		}else{
			Set<String> roles = rolesRepository.findByUserName(userName);
			return new SecuredUserDetails(user,roles);
		}
	}

}
