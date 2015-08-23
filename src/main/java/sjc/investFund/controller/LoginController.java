package sjc.investFund.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = {"", "/", "/login"}, method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = {"", "/", "/login"}, method = RequestMethod.POST)
	public ModelAndView login(
		@RequestParam(value = "login", required = true) String login,
		@RequestParam(value = "password", required = true) String password, 
		HttpSession session) {
			
		ModelAndView mav = new ModelAndView();
		User user = userService.findByLoginAndPassword(login, password);
		session.setAttribute("user", user);
//		mav.addObject("user", user);
//		mav.addObject("projectlist", projectService.findProjectsByUser(user));
		mav.setViewName("redirect:/creator/"+ user.getId().toString());
		return mav;
	}
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {

		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		
		session.setAttribute("user", null);
		session.invalidate();
		
		return model;
	}
	
}
