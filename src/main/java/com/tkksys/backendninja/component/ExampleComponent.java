package com.tkksys.backendninja.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {
	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);
	
	public void sayHello() {
		LOG.info("Hello From Component");
	}

}
