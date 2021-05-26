package py.com.tickets.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class TestCryp.
 */
public class LetsCryp {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public String encrypt(String pass) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		String newPass = pe.encode(pass);
		return newPass; 
	}
}
