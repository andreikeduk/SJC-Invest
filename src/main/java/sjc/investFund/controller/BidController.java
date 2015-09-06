package sjc.investFund.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.io.Files;

import sjc.investFund.dto.service.AreaInfoDtoService;
import sjc.investFund.exception.AlredyExistException;
import sjc.investFund.model.Account;
import sjc.investFund.model.Area;
import sjc.investFund.model.Bid;
import sjc.investFund.model.BidStatus;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;
import sjc.investFund.service.AreaService;
import sjc.investFund.service.BidService;
import sjc.investFund.service.ProjectService;
import sjc.investFund.service.UserService;

@Controller
@RequestMapping("/bid")
public class BidController {

	@Autowired
	private BidService bidService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private AreaInfoDtoService areaDto;

	private static final Logger logger = Logger.getLogger(BidController.class);

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newBidForm(Model model) {

		model.addAttribute("project", new Project());
		model.addAttribute("action", "new");
		// model.addAttribute("arealist", areaService.getAreaMap());
		return "bid";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView addBid(
			@ModelAttribute("project") @Valid Project project,
			BindingResult br, Authentication auth) throws AlredyExistException {
		ModelAndView mav = new ModelAndView();
		String view = "redirect:/creator";

		if (br.hasErrors()) {
			mav.addObject("arealist", areaService.getAreaMap());
			view = "bid";
			logger.info("New bid with name:" + project.getName()
					+ " has error ");
		} else {
			User user = userService.findByLogin(auth.getName());
			projectService.createProject(project, user);
			logger.info("New bid with name:" + project.getName() + " created ");
		}
		mav.setViewName(view);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listBid() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("bidslist", bidService.findAllBids());
		mav.setViewName("bidlist");
		return mav;
	}

	// andrew
	@RequestMapping(value = "/area/{id}", method = RequestMethod.GET)
	public String getAreaBids(@PathVariable("id") Area area, Model model) {
		model.addAttribute("areainfo", areaDto.getAreaInfo(area));
		model.addAttribute("areabids", bidService.findBidsByArea(area));
		//model.addAttribute("area", area.getName());
		return "area.bids";
	}
}
