package py.com.tickets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

	private String username;
	private boolean enabled;
	private String password;
	private String userRol;

}
