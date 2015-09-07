package sjc.investFund.controller;

import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.exception.AlredyExistException;
import sjc.investFund.model.Creator;
import sjc.investFund.model.Director;
import sjc.investFund.model.Investor;
import sjc.investFund.model.User;
import sjc.investFund.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUsers(Map<String, Object> map) {

		map.put("userList", userService.findAllUsers());
		return "users.list";
	}

	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("action", "add");

		return "user";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user,
			BindingResult result, Model model) throws AlredyExistException {

		String view = "home";
		if (result.hasErrors()) {
			view = "user";
		} else {
			if (user != null) {
				String role = user.getRole().toString();
				if (role.equals("INVESTOR")) {
					user = new Investor(user);
				} else if (role.equals("CREATOR")) {
					user = new Creator(user);
				} else if (role.equals("DIRECTOR")) {
					user = new Director(user);
				}
				userService.create(user);
			}
		}
		return view;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(Model model, Authentication auth) {

		User user = userService.findByLogin(auth.getName());
		model.addAttribute("user", user);
		model.addAttribute("action", "edit");
		return "user";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editClientSubmit(
			@ModelAttribute("user") @Valid User newUser, BindingResult br,
			@RequestParam("id") String id, Authentication auth)
			throws AlredyExistException {
		ModelAndView mav = new ModelAndView();
		String view = "redirect:/profile";
		if (br.hasErrors()) {
			view = "user";
		} else {
			User oldUser = userService.findById(Integer.parseInt(id));
			System.out.println(newUser.getFirstName());
			userService.update(oldUser, newUser);
			mav.addObject("user", oldUser);
			if (!oldUser.getLogin().equals(auth.getName())) {
				view = "redirect:/j_spring_security_logout";
			}
		}
		mav.setViewName(view);
		return mav;
	}
}
