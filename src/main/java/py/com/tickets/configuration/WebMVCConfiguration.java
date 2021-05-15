package py.com.tickets.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import py.com.tickets.component.RequestTimeInterceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class WebMVCConfiguration.
 */
@Configuration
public class WebMVCConfiguration extends WebMvcConfigurerAdapter{
	
	/** The request time interceptor. */
	@Autowired
	@Qualifier("requestTimeInterceptor")
	RequestTimeInterceptor requestTimeInterceptor;
	
	/**
	 * Adds the interceptors.
	 *
	 * @param registry the registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestTimeInterceptor);
	}
	
	
}
