package learn.springboot.user.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "USER_DETAILS")
@Getter @Setter @NoArgsConstructor
public class User {
	
	@Column(name = "user_id")
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
	@SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "USER_ID_SEQUENCE")
	private int id;
	
	private String name;
	private String password;
	private String emailId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles_mapper", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	public User(User user) {
		this.id = user.getId();
		this.password = user.getPassword();
		this.name = user.getName();
		this.emailId = user.getEmailId();
	}
}
