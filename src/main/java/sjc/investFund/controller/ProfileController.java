package sjc.investFund.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.model.User;
import sjc.investFund.service.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public ModelAndView profile(HttpSession session, Authentication auth) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("profile");

		User user = userService.findByLogin(auth.getName());
		
		if (user!= null) {
			mav.addObject("user", user);
		}
		return mav;
	}
}
