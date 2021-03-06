package py.com.tickets.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import py.com.tickets.util.ViewConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	/**
	 * Show login form.
	 *
	 * @param model  the model
	 * @param error  the error
	 * @param logout the logout
	 * @return the string
	 */
	@RequestMapping({ "/login" })
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOG.info("--METHOD: showLoginForm() --PARAMS: error=" + error + ", logout=" + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("Returning to login view");
		return ViewConstants.LOGIN;
	}

	/**
	 * Login check.
	 *
	 * @return the string
	 */
	@GetMapping({ "/logincheck", "/", "/home", "/index" })
	public String loginCheck() {
		LOG.info("--METHOD: loginCheck()");
		LOG.info("Retorna la vista al dashboard");
		return ViewConstants.DASHBOARD;
	}
}
