package learn.springboot.test.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("test/role")
@Api(tags = "Role Based Authentication Apis")
public class RoleBasedAuthentication {
	
	@GetMapping("admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminRoleEndpoint() {
		return "Your are allowed with ADMIN Role";
	}
	
	@GetMapping("dba")
	@PreAuthorize("hasRole('ADMIN') or hasRole('DBA')")
	public String dbaRoleEndpoint() {
		return "Your are allowed with ADMIN/DBA Role";
	}
	
	@GetMapping("developer")
	@PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
	public String developerRoleEndpoint() {
		return "Your are allowed with DEVELOPER/ADMIN Role";
	}
	
	@GetMapping("user")
	public String userRoleEndpoint() {
		return "Your are allowed with USER/ADMIN/DBA/DEVELOPER Role";
	}
}
