package sjc.investFund.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import sjc.investFund.model.Comment;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;
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
	private TransactionService transactionService;

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
		model.addAttribute("action");

		return "project.details";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String addComment(@PathVariable("id") Project project,
			@ModelAttribute("comment") Comment comment, Model model,
			HttpSession session) {
		commentService.createComment(comment);
		String view = "project.details";
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

	@RequestMapping(value = "/{id}/sendClaim", method = RequestMethod.GET)
	public String sendClaim(@PathVariable("id") Project project,
			HttpSession session, Model model) {
		model.addAttribute("project", project);

		return "sendClaim";
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
}