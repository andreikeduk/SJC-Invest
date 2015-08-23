package sjc.investFund.controller;

import java.text.DateFormat;
import java.util.Collection;
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
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.model.Role;
import sjc.investFund.model.User;
import sjc.investFund.repository.UserRepository;
import sjc.investFund.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/hell")
public class HellController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(){
		
		return new ModelAndView("home", "user", new User());
	}
	@RequestMapping(value = "/adduser")
	public ModelAndView adduser(@ModelAttribute("user") User user){
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", user);
		mav.setViewName("home");
		
		
		return mav;
	}
		
}
