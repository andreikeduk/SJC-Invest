package sjc.investFund.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

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
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUsers(Map<String, Object> map) {

			map.put("userList", userService.findAllUsers());

			return "userslist";
	}
	@RequestMapping(value = "/")
	public String home(){
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String listUsers() {
		
		return "user";
	}
	@RequestMapping(value = "/adduser/add", method = RequestMethod.POST)
	public String addUser(Model model) {
			
		return "redirect:/index";
		
	}
		
}
