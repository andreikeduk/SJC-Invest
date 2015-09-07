package sjc.investFund.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.domain.model.User;
import sjc.investFund.domain.service.BidService;
import sjc.investFund.domain.service.ProjectService;
import sjc.investFund.domain.service.UserService;

@Controller
@RequestMapping("/creator")
public class CreatorController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private BidService bidService;

	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public ModelAndView creatorRoom(Authentication auth) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("creator.room");

		User user = userService.findByLogin(auth.getName());
		if ((user!= null) && (user instanceof User)) {			
			mav.addObject("bidslist", bidService.getBidsByUser(user));
		}
		return mav;
	}
}
