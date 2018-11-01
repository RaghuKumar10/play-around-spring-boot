package learn.springboot.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import learn.springboot.exception.RecordsNotFoundException;
import learn.springboot.exception.ResourceNotFoundException;
import learn.springboot.user.entity.User;
import learn.springboot.user.service.UserService;

@RestController
@RequestMapping("users")
@Api(tags = "User CRUD Apis")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "${'swagger.usercontroller.create.value'}", code = 201, response = User.class)
	public User create(@RequestBody User user) {
		return userService.create(user);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.FOUND)
	@ApiOperation(value = "${'swagger.usercontroller.getall.value'}", code = 302, responseContainer = "LIST")
	public List<User> getUsers() throws RecordsNotFoundException{
		return userService.getAll();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.FOUND)
	@ApiOperation(value = "${'swagger.usercontroller.get.value'}", code = 302, response = User.class)
	public User getUser(@PathVariable int id) throws ResourceNotFoundException {
		return userService.get(id);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "${'swagger.usercontroller.update.value'}", code = 200, response = User.class)
	public User update(@RequestBody User user, @PathVariable int id) {
		return userService.update(id, user);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)@ApiOperation(value = "${'swagger.usercontroller.delete.value'}", code = 204)
	public void delete(@PathVariable int id) {
		userService.delete(id);
	}
}
