package com.tkksys.backendninja.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	/**
	 * Metodo que se ejecuta antes de realizar la peticion dentro del otro metodo donde fue invocado
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("starTime", System.currentTimeMillis()); //captura el tiempo actual en milisegundos
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long starTime = (long) request.getAttribute("starTime");
		LOG.info("URL to: '"+request.getRequestURL().toString() + "' in: '"+ (System.currentTimeMillis() - starTime) + "ms'");
	}
	
	

}
