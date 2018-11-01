package learn.springboot.user.service;

import java.util.List;

import learn.springboot.exception.RecordsNotFoundException;
import learn.springboot.exception.ResourceNotFoundException;
import learn.springboot.user.dto.UserDto;
import learn.springboot.user.entity.User;

public interface UserService {
	List<User> getAll() throws RecordsNotFoundException;
	User get(int id) throws ResourceNotFoundException;
	User create(UserDto userDto);
	void delete(int id);
	User update(int id, User user);
}
