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

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView listProjects(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectslist", projectService.findAllBids());
		mav.setViewName("projects");
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showUserProfile(@PathVariable("id") Project project,
			HttpSession session, Model model) {

		model.addAttribute("project", project);

		return "project.details";
	}
}
