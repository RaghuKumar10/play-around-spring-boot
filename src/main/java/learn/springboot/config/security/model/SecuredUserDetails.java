package learn.springboot.config.security.model;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import learn.springboot.user.entity.User;

public class SecuredUserDetails extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private transient Set<String> roles; 
	
	public SecuredUserDetails(User user, Set<String> roles) {
		super(user);
		this.roles = roles;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String rolesDelimited = StringUtils.collectionToCommaDelimitedString(roles);			
		return AuthorityUtils.commaSeparatedStringToAuthorityList(rolesDelimited);
	}

	@Override
	public String getUsername() {
		return super.getEmailId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
