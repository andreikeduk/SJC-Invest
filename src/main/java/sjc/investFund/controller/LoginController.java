package sjc.investFund.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.service.AreaService;
import sjc.investFund.service.ProjectService;
import sjc.investFund.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private AreaService areaService;

	private static final Logger logger = Logger
			.getLogger(LoginController.class);

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String login(HttpSession session) {
		session.setAttribute("arealist", areaService.getAreaMap());
		return "login";
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.POST)
	public ModelAndView login(
			@RequestParam(value = "login", required = true) String login,
			@RequestParam(value = "password", required = true) String password,
			HttpRequest request, HttpSession session) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/redirector");
		logger.info("User '" + login + "' entered.");
		return mav;
	}

	@RequestMapping(value = "/failure", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		logger.info("Failed login");
		return "login";
	}

}
