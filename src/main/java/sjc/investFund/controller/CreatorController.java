package sjc.investFund.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.model.User;
import sjc.investFund.service.ProjectService;
import sjc.investFund.service.UserService;

@Controller
@RequestMapping("/creator")
public class CreatorController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/{login}", method = RequestMethod.GET)
	public ModelAndView creatorRoom(@PathVariable("login") String login,
			HttpSession session) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("creator.room");

		Object userObject = session.getAttribute("user");
		if ((userObject != null) && (userObject instanceof User)) {
			User user = (User) userObject;
			mav.addObject("projectlist", projectService.findProjectsByUser(user));

		}
		return mav;
	}
}
