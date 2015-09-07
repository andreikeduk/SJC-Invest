package sjc.investFund.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.domain.model.BidStatus;
import sjc.investFund.domain.service.BidService;
import sjc.investFund.domain.service.ProjectService;
import sjc.investFund.domain.service.UserService;

@Controller
@RequestMapping("/director")
public class DirectorController {
	@Autowired
	private UserService userService;

	@Autowired
	private BidService bidService;

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ModelAndView directorRoom() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("director.room");
		mav.addObject("bidslist", bidService.findAllBids());
		return mav;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getAllBids() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("director.room");
		mav.addObject("bidslist", bidService.findAllBids());
		return mav;
	}

	@RequestMapping(value = "/accepted", method = RequestMethod.GET)
	public ModelAndView getAcceptedProjects() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("director.room");
		mav.addObject("bidslist",
				bidService.findBidsByStatus(BidStatus.ACCEPTED));
		return mav;
	}

	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public ModelAndView getDeniedProjects() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("director.room");
		mav.addObject("bidslist", bidService.findBidsByStatus(BidStatus.DENIED));
		return mav;
	}

	@RequestMapping(value = "/underconsideration", method = RequestMethod.GET)
	public ModelAndView getConsiderationProjects() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("director.room");
		mav.addObject("bidslist",
				bidService.findBidsByStatus(BidStatus.UNDER_CONSIDERATION));
		return mav;
	}

	@RequestMapping(value = "/ready", method = RequestMethod.GET)
	public ModelAndView getReadyProjects() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("director.projects");
		mav.addObject("projectslist", projectService.findReadyProjects(true));
		return mav;
	}

}
