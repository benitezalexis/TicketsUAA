package py.com.tickets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import py.com.tickets.entity.UserRol;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserModel {

	private Long id;
	private String username;
	private String password;
	private boolean enabled;
	private UserRol userRol;

}
