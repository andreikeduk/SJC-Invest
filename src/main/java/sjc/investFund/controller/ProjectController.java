package sjc.investFund.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.model.Project;
import sjc.investFund.service.ProjectService;
import sjc.investFund.service.TransactionService;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

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

		return "project.details";
	}

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