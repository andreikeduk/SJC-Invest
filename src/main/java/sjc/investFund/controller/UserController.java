package sjc.investFund.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.model.Creator;
import sjc.investFund.model.Director;
import sjc.investFund.model.Investor;
import sjc.investFund.model.Role;
import sjc.investFund.model.User;
import sjc.investFund.repository.UserRepository;
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
		//model.addAttribute("roleOptions", Role.values());

		return "user";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user,
			@RequestParam("role") String role, BindingResult result, Model model) {
		
		String view = "home";
		if (result.hasErrors()) {
			view = "user";
		} else {
			if (user != null) {
				if (role.equals("INV") ) {		
					user = new Investor(user);
				} else if(role.equals("CRE")) {					
					user = new Creator(user);
				}else if(role.equals("DIR")) {				
					user = new Director(user);
				}
				userService.create(user);
			}
		}
		return view;
	}

}
