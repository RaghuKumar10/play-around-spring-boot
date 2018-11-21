package learn.springboot.user.service;

import java.util.List;

import learn.springboot.exception.RecordsNotFoundException;
import learn.springboot.exception.ResourceNotFoundException;
import learn.springboot.user.dto.UserDto;
import learn.springboot.user.entity.User;

public interface UserService {
	List<User> getAll() throws RecordsNotFoundException;
	User get(long id) throws ResourceNotFoundException;
	User create(UserDto userDto);
	void delete(long id);
	User update(long id, User user);
}
