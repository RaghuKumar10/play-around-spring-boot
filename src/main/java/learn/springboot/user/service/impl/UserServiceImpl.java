package learn.springboot.user.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import learn.springboot.exception.RecordsNotFoundException;
import learn.springboot.exception.ResourceNotFoundException;
import learn.springboot.user.dto.UserDto;
import learn.springboot.user.entity.Role;
import learn.springboot.user.entity.User;
import learn.springboot.user.repository.RolesRepository;
import learn.springboot.user.repository.UserRepository;
import learn.springboot.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private RolesRepository roleRepository;
	private ModelMapper modelMapper;
	@Autowired private Environment env;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RolesRepository roleRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.roleRepository = roleRepository;
		this.modelMapper = modelMapper;
	}
	@Override
	public List<User> getAll() throws RecordsNotFoundException {
		List<User> users = userRepository.findAll();
		if(users == null || users.isEmpty())
			throw new RecordsNotFoundException("Users Does Not Exists");
		return users;
	}

	@Override
	public User get(long id) throws ResourceNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
			return user.get();
		throw new ResourceNotFoundException("User does not found with User Id : " + id);
	}

	@Override
	public void delete(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User update(long id, User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User create(UserDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Set<Role> roles = roleRepository.findByRoleName(env.getProperty("user.default.userrole"));
		User user = modelMapper.map(userDto, User.class);
		user.setEnabled(env.getProperty("user.default.status"));
		user.setLastPasswordResetDate(new Date());
		user.setRoles(roles);
		return userRepository.save(user);
	}

}
