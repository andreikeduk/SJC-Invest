package sjc.investFund.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.model.Account;
import sjc.investFund.model.Area;
import sjc.investFund.model.Bid;
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

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newBidForm(Model model) {

		model.addAttribute("project", new Project());
		model.addAttribute("action", "new");

		Map<String, String> areaList = new LinkedHashMap<String, String>();

		List<Area> areas = areaService.findAllAreas();
		for (Area a : areas) {
			areaList.put(a.getId().toString(), a.getName());
		}
		model.addAttribute("arealist", areaList);

		return "bid";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView addbid(
			@ModelAttribute("project") @Valid Project project,
			BindingResult br, HttpSession session, Authentication auth) {
		String view = "/profile";

		if (br.hasErrors()) {
			view = "bid";
		} else {
			if (project != null) {
				User user = userService.findByLogin(auth.getName());

				if ((user != null) && (user instanceof User)) {
					Account acc = new Account();
					Bid bid = new Bid();
					bid.setProject(project);

					project.setUser(user);
					project.setAccount(acc);
					projectService.createProject(project);
					bidService.create(bid);
				}
			}
		}

		return new ModelAndView(view);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listBid() {

		ModelAndView mav = new ModelAndView();
		mav.addObject("bidslist", bidService.findAllBids());
		mav.setViewName("bidlist");
		return mav;

	}

}
