package learn.springboot.user.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import learn.springboot.user.entity.Role;

@Repository
public interface RolesRepository extends CrudRepository<Role, Integer>{
	
	Set<Role> findByRoleName(String roleName);
	
	@Query(value = "select r.role_name from user_details u inner join user_roles_mapper ur on(u.user_id=ur.user_id) inner join user_roles r on(ur.role_id = r.role_id) where u.email_id = :userName", nativeQuery = true)
	Set<String> findByUserName(@Param("userName")String userName);
}
