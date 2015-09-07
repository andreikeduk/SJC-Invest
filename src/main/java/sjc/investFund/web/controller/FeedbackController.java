package sjc.investFund.web.controller;

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

import sjc.investFund.domain.model.Claim;
import sjc.investFund.domain.model.Comment;
import sjc.investFund.domain.model.Mark;
import sjc.investFund.domain.model.Popularity;
import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.model.User;
import sjc.investFund.domain.service.ClaimService;
import sjc.investFund.domain.service.CommentService;
import sjc.investFund.domain.service.MarkService;
import sjc.investFund.domain.service.PopularityService;
import sjc.investFund.domain.service.UserService;

@Controller
@RequestMapping(value = "/projects/{id}")
public class FeedbackController {
	
	@Autowired
	private CommentService commentService;

	@Autowired
	private ClaimService claimService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MarkService markService;
	
	@Autowired
	private PopularityService popularityService;
	
	private String view = "redirect:/projects/{id}";
	
	@RequestMapping(value = "/sendMark", method = RequestMethod.GET)
	public String addMark(@PathVariable("id") Project project,
			HttpSession session, Model model) {

		model.addAttribute("mark", new Mark());
		model.addAttribute("action");

		return "sendMark";
	}

	@RequestMapping(value = "/sendMark", method = RequestMethod.POST)
	public String addMark(@PathVariable("id") Project project,
			@ModelAttribute("mark") @Valid Mark mark,
			BindingResult bindingResult, Model model, HttpSession session,
			Authentication auth) {

		if (bindingResult.hasErrors()) {
			view = "sendMark";
		} else {
			view = "redirect:/projects/{id}";
			User user = userService.findByLogin(auth.getName());
			mark.setUser(user);
			mark.setProject(project);
			markService.createMark(mark);
			model.asMap().remove("mark");
		}

		return view;
	}

	@RequestMapping(value = "/sendLike", method = RequestMethod.GET)
	public String addLike(@PathVariable("id") Project project,
			HttpSession session, Model model) {

		model.addAttribute("popularity", new Popularity());
		model.addAttribute("action");

		return "sendLike";
	}

	@RequestMapping(value = "/sendLike", method = RequestMethod.POST)
	public String addLike(@PathVariable("id") Project project,
			@ModelAttribute("popularity") Popularity popularity,
			BindingResult bindingResult, Model model, HttpSession session,
			Authentication auth) {

		view = "redirect:/projects/{id}";

		User user = userService.findByLogin(auth.getName());
		popularity.setUser(user);
		popularity.setProject(project);
		popularityService.addLike(popularity);
		model.asMap().remove("popularity");

		return view;
	}

	@RequestMapping(value = "/sendComment", method = RequestMethod.GET)
	public String addComment(@PathVariable("id") Project project,
			HttpSession session, Model model) {
		model.addAttribute("project", project);
		model.addAttribute("comment", new Comment());
		model.addAttribute("action");

		return "sendComment";
	}

	@RequestMapping(value = "/sendComment", method = RequestMethod.POST)
	public String addComment(@PathVariable("id") Project project,
			@ModelAttribute("comment") @Valid Comment comment,
			BindingResult bindingResult, Model model, HttpSession session,
			Authentication auth) {

		if (bindingResult.hasErrors()) {
			view = "sendComment";
		} else {
			view = "redirect:/projects/{id}";
			User user = userService.findByLogin(auth.getName());
			comment.setUser(user);
			comment.setProject(project);
			commentService.createComment(comment);
			model.asMap().remove("comment");
		}

		return view;
	}

	@RequestMapping(value = "/sendClaim", method = RequestMethod.GET)
	public String sendClaim(@PathVariable("id") Project project,
			HttpSession session, Model model) {
		model.addAttribute("project", project);
		model.addAttribute("claim", new Claim());
		model.addAttribute("claimaction");

		return "sendClaim";
	}

	@RequestMapping(value = "/sendClaim", method = RequestMethod.POST)
	public String sendClaim(@PathVariable("id") Project project,
			@ModelAttribute("claim") @Valid Claim claim,
			BindingResult bindingResult, HttpSession session, Model model,
			Authentication auth) {

		if (bindingResult.hasErrors()) {
			view = "sendClaim";
		} else {
			view = "redirect:/projects/{id}";
			User user = userService.findByLogin(auth.getName());
			claim.setUser(user);
			claim.setProject(project);
			claimService.createClaim(claim);
			model.asMap().remove("claim");
		}

		return view;
	}
}
