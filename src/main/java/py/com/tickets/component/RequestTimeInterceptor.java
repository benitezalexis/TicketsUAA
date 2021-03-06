package py.com.tickets.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import py.com.tickets.repository.LogRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestTimeInterceptor.
 */
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{
	
	/** The log repository. */
	@Autowired
	@Qualifier("logRepository")
	private LogRepository logRepository;
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	/**
	 * Metodo que se ejecuta antes de realizar la peticion dentro del otro metodo donde fue invocado.
	 *
	 * @param request the request
	 * @param response the response
	 * @param handler the handler
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("starTime", System.currentTimeMillis()); //captura el tiempo actual en milisegundos
		return true;
	}

	/**
	 * After completion.
	 *
	 * @param request the request
	 * @param response the response
	 * @param handler the handler
	 * @param ex the ex
	 * @throws Exception the exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long starTime = (long) request.getAttribute("starTime");
		String url = request.getRequestURL().toString();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		if(auth != null && auth.isAuthenticated()) {
			username = auth.getName();
			
		}
		
		logRepository.save(new py.com.tickets.entity.Log(new Date(), auth.getDetails().toString(), username, url));
		LOG.info("URL to: '"+ url + "' in: '"+ (System.currentTimeMillis() - starTime) + "ms'");
	}
	
	

}
