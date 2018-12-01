package learn.springboot.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "USER_ROLES")
@Getter @Setter @NoArgsConstructor
public class Role {
	
	@Column(name = "role_id")
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_ID_GENERATOR")
	@SequenceGenerator(name = "ROLE_ID_GENERATOR", sequenceName = "ROLE_ID_SEQENCE", initialValue = 5)
    private int id;
	
    @Column(name = "role_name")
    private String roleName;
}
