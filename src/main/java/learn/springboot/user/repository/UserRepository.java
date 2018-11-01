package learn.springboot.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import learn.springboot.user.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	@Override
	List<User> findAll();
	
	User findByEmailId(String emailId);
}
