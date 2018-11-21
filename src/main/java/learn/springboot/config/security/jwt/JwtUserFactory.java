package learn.springboot.config.security.jwt;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import learn.springboot.config.security.model.SecuredUserDetails;
import learn.springboot.user.entity.Role;
import learn.springboot.user.entity.User;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static SecuredUserDetails create(User user) {
        return new SecuredUserDetails(user, mapToGrantedAuthorities(user.getRoles()));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Set<Role> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRoleName()))
                .collect(Collectors.toList());
    }
}
