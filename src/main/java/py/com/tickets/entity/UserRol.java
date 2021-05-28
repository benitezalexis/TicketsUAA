package py.com.tickets.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_roles", uniqueConstraints = @UniqueConstraint(columnNames = { "role", "username" }))
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class UserRol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "user_role_id", unique= true, nullable = false)
	private Integer userRoleId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username", nullable = false)
	private User user;
	
	@Column(name = "role", nullable = false, length = 45)
	private String role;

	public UserRol(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}

}
