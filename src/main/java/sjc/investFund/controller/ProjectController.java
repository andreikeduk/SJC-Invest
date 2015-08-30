package sjc.investFund.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.model.Account;
import sjc.investFund.model.Area;
import sjc.investFund.model.Bid;
import sjc.investFund.model.Claim;
import sjc.investFund.model.Comment;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;
import sjc.investFund.repository.AreaRepository;
import sjc.investFund.service.AreaService;
import sjc.investFund.service.BidService;
import sjc.investFund.service.ClaimService;
import sjc.investFund.service.CommentService;
import sjc.investFund.service.ProjectService;
import sjc.investFund.service.TransactionService;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private ClaimService claimService;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private AreaService areaService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView listProjects(HttpSession session) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("projectslist", projectService.findAllBids());
		mav.setViewName("projects");
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showProject(@PathVariable("id") Project project,
			HttpSession session, Model model) {
		model.addAttribute("project", project);
		model.addAttribute("comment", new Comment());
		List<Comment> comments = commentService.getCommentsByProject(project);
		model.addAttribute("comments", comments);
		model.addAttribute("action");

		return "project.details";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String addComment(@PathVariable("id") Project project,
			@ModelAttribute("comment") Comment comment,
			BindingResult bindingResult, Model model, HttpSession session) {
		commentService.createComment(comment);
		model.asMap().remove("comment");
		String view = "project.details";
		return view;
	}

	@RequestMapping(value = "/{id}/sendClaim", method = RequestMethod.GET)
	public String sendClaim(@PathVariable("id") Project project,
			HttpSession session, Model model) {
		model.addAttribute("project", project);
		model.addAttribute("claim", new Claim());
		model.addAttribute("claimaction");

		return "sendClaim";
	}

	@RequestMapping(value = "/{id}/sendClaim", method = RequestMethod.POST)
	public String sendClaim(@PathVariable("id") Project project,
			@ModelAttribute("claim") Claim claim, BindingResult bindingResult,
			HttpSession session, Model model) {
		claimService.createClaim(claim);
		model.asMap().remove("claim");
		String view = "infoSendingClaim";
		return view;
	}

	/*
	 * @RequestMapping(value = "/new", method = RequestMethod.GET) public String
	 * newBidForm(Model model) {
	 * 
	 * model.addAttribute("project", new Project());
	 * model.addAttribute("action", "new");
	 * 
	 * Map<String, String> areaList = new LinkedHashMap<String, String>();
	 * 
	 * List<Area> areas = areaService.findAllAreas(); for (Area a : areas) {
	 * areaList.put(a.getId().toString(), a.getName()); }
	 * model.addAttribute("arealist", areaList);
	 * 
	 * return "bid"; }
	 */

	@RequestMapping(value = "/{id}/sendMoney", method = RequestMethod.GET)
	public String sendMoney(@PathVariable("id") Project project,
			HttpSession session, Model model) {
		model.addAttribute("project", project);

		return "sendMoney";
	}

	/*
	 * @RequestMapping(value = "/{id}/sendMoney", method = RequestMethod.POST)
	 * public ModelAndView sendMoney(@ModelAttribute Transaction transaction,
	 * 
	 * @RequestParam(value = "country") String countryCode,
	 * 
	 * @RequestParam(value = "multipleOptions") String[] options, Model model) {
	 * transactionService.saveTransaction(transaction); ModelAndView mav = new
	 * ModelAndView(); User user = userService.findByName(login);
	 * session.setAttribute("user", user); mav.addObject("user", user);
	 * mav.setViewName("home"); return mav; }
	 */

	// andrew
	@PreAuthorize("hasRole('ROLE_CREATOR')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editProject(@PathVariable("id") Project project,
			HttpSession session, Model model) {

		getAreaList(model);
		model.addAttribute("project", project);
		model.addAttribute("action", project.getId());

		return "bid";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String addBid(@ModelAttribute("project") @Valid Project project,
			BindingResult br, Authentication auth, Model model) {
		String view = "redirect:/projects/{id}";

		if (br.hasErrors()) {
			getAreaList(model);
			view = "bid";
		} else {
			
			projectService.updateProject(project);
		}
		return view;
	}

	public void getAreaList(Model model) {
		Map<String, String> areaList = new LinkedHashMap<String, String>();

		List<Area> areas = areaService.findAllAreas();
		for (Area a : areas) {
			areaList.put(a.getId().toString(), a.getName());
		}
		model.addAttribute("arealist", areaList);
	}

}