package sjc.investFund.controller;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.model.Role;
import sjc.investFund.model.User;
import sjc.investFund.service.ProjectService;
import sjc.investFund.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = { "", "/"}, method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.POST)
	public ModelAndView login(
			@RequestParam(value = "login", required = true) String login,
			@RequestParam(value = "password", required = true) String password,
			HttpRequest request, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		User user = userService.findByLoginAndPassword(login, password);
		//session.setAttribute("user", user.getLogin());
		//mav.addObject("user", user);
		// mav.addObject("projectlist",
		// projectService.findProjectsByUser(user));
		mav.setViewName("redirect:/redirector");
		return mav;
	}

	@RequestMapping(value = "/failure", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error",
				"This combination user and password not found");
		return "login";
	}
	
	
}
