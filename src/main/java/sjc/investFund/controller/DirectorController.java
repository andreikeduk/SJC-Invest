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
import sjc.investFund.service.BidService;
import sjc.investFund.service.ProjectService;
import sjc.investFund.service.UserService;

@Controller
@RequestMapping("/director")
public class DirectorController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BidService bidService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ModelAndView directorRoom() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("director.room");
		mav.addObject("bidslist", bidService.findAllBids());
		return mav;

	}
	
}
