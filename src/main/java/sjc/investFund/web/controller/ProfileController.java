package sjc.investFund.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sjc.investFund.domain.model.User;
import sjc.investFund.domain.service.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String profile(Authentication auth, Model model) {
		User user = userService.findByLogin(auth.getName());
		if (user != null) {
			model.addAttribute("user", user);
		}
		return "profile";
	}
}
