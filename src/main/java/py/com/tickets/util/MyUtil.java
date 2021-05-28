package py.com.tickets.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class MyUtil.
 */
@Component
public class MyUtil {
	
	/**
	 * Validacion de campos nulos.
	 *
	 * @param obj the obj
	 * @return the string
	 */
	public static String isNull(Object obj) {
		return obj == null ? "" : (String) obj;
	}
	
	public String encriptarPass(String pass) {		
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		String newPass = pe.encode(pass);
		return newPass;
	}
}
