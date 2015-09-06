package sjc.investFund.controller;

import java.util.Calendar;
import java.util.List;


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

import sjc.investFund.dto.AreaInfoDto;
import sjc.investFund.dto.service.AreaInfoDtoService;
import sjc.investFund.exception.AlredyExistException;
import sjc.investFund.model.Area;
import sjc.investFund.model.Bankcard;
import sjc.investFund.model.Bid;
import sjc.investFund.model.BidStatus;
import sjc.investFund.model.Claim;
import sjc.investFund.model.Comment;
import sjc.investFund.model.Datachek;
import sjc.investFund.model.Investor;
import sjc.investFund.model.Mark;
import sjc.investFund.model.Popularity;
import sjc.investFund.model.Project;
import sjc.investFund.model.Transaction;
import sjc.investFund.model.Transfer;
import sjc.investFund.model.User;
import sjc.investFund.service.AreaService;
import sjc.investFund.service.BankcardService;
import sjc.investFund.service.BidService;
import sjc.investFund.service.ClaimService;
import sjc.investFund.service.CommentService;
import sjc.investFund.service.DatachekService;
import sjc.investFund.service.InvestorService;
import sjc.investFund.service.MarkService;
import sjc.investFund.service.PopularityService;
import sjc.investFund.service.ProjectService;
import sjc.investFund.service.TransactionService;
import sjc.investFund.service.TransferService;
import sjc.investFund.service.UserService;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private BidService bidService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private AreaService areaService;

	@Autowired
	private MarkService markService;

	@Autowired
	private PopularityService popularityService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_INVESTOR')")
	public ModelAndView listProjects(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectslist", projectService.findAllBids());
		mav.setViewName("projects");

		return mav;
	}

	// andrew. this method must be rewrite
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showProject(@PathVariable("id") Project project,
			HttpSession session, Model model) {

		Calendar expirationDate = projectService.getExpirationDate(project);
		if (expirationDate != null) {
			model.addAttribute("deadline", expirationDate.getTime());
		}
		model.addAttribute("project", project);
		List<Comment> comments = commentService.getCommentsByProject(project);
		model.addAttribute("comments", comments);

		List<Popularity> popularities = popularityService
				.getLikesByProject(project);
		model.addAttribute("countLikes", popularities.size());

		List<Mark> marks = markService.getMarksByProject(project);
		model.addAttribute("averageValue", marks.size());

		return "project.details";
	}

	@PreAuthorize("project.user.login.equals(auth.name)")
	// @PreAuthorize("hasRole('ROLE_CREATOR')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editProject(@PathVariable("id") Project project,
			HttpSession session, Authentication auth, Model model) {

		model.addAttribute("arealist", areaService.getAreaMap());
		model.addAttribute("project", project);
		model.addAttribute("action", project.getId());

		return "bid";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String addBid(@ModelAttribute("project") @Valid Project newProject,
			BindingResult br, Authentication auth, Model model,
			@PathVariable("id") Integer id) throws AlredyExistException {
		String view = "redirect:/projects/{id}";

		if (br.hasErrors()) {
			model.addAttribute("arealist", areaService.getAreaMap());
			view = "bid";
		} else {
			Project oldProject = projectService.getProjectById(id);
			projectService.updateProject(oldProject, newProject);
		}
		return view;
	}

	@RequestMapping(value = "/{id}/transactions", method = RequestMethod.GET)
	public String getTransactions(Model model, @PathVariable("id") Integer id) {
		Project project = projectService.getProjectById(id);
		model.addAttribute("transactionsList",
				transactionService.findTransactionsOfProject(project));
		return "project.transactions";
	}

	@RequestMapping(value = "/area/{id}", method = RequestMethod.GET)
	public String getAreaBids(@PathVariable("id") Area area, Model model) {

		model.addAttribute("areabids",
				bidService.findBidsByAreaStatus(area, BidStatus.ACCEPTED));
		model.addAttribute("area", area.getName());
		return "area.bids";
	}

	@PreAuthorize("hasRole('ROLE_DIRECTOR')")
	@RequestMapping(value = "/{id}/accept", method = RequestMethod.GET)
	public String acceptBid(@PathVariable("id") Project project, Model model) {
		Bid bid = bidService.getProjectBid(project);
		bidService.acceptBid(bid);
		return "redirect:/projects/{id}";
	}

	@PreAuthorize("hasRole('ROLE_DIRECTOR')")
	@RequestMapping(value = "/{id}/deny", method = RequestMethod.GET)
	public String denyBid(@PathVariable("id") Project project, Model model) {
		Bid bid = bidService.getProjectBid(project);
		bidService.denyBid(bid);
		return "redirect:/projects/{id}";
	}
}