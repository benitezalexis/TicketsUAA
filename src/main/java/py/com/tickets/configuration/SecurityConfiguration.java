package py.com.tickets.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityConfiguration.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	/** The user service. */
	@Autowired
	@Qualifier("userService")
	private UserDetailsService userService;
	
	/**
	 * Configure global.
	 *
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	/**
	 * Configure para profile DEV
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin/**", "/css/**", "/js/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/logincheck")
				.usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/").permitAll()
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll();
		//super.configure(http);
		/**
		 * You should not call super.configure(http) since you want to use a custom security configuration.
		 * The error is caused because the parent configure(http) method is already calling .authorizeRequests().anyRequest().authenticated() and as the error message mentions 
		 */
	//}

	/**
	 * Configure para profile PRO
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin/**", "/css/**", "/js/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login").loginProcessingUrl("tikets/logincheck")
				.usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/").permitAll()
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll();
		//super.configure(http);
		/**
		 * You should not call super.configure(http) since you want to use a custom security configuration.
		 * The error is caused because the parent configure(http) method is already calling .authorizeRequests().anyRequest().authenticated() and as the error message mentions 
		 */
	}
}
