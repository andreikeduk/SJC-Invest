package sjc.investFund.controller;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
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

import sjc.investFund.model.Area;
import sjc.investFund.model.Bid;
import sjc.investFund.model.BidStatus;
import sjc.investFund.model.Claim;
import sjc.investFund.model.Comment;
import sjc.investFund.model.Investor;
import sjc.investFund.model.Project;
import sjc.investFund.model.Transaction;
import sjc.investFund.model.User;
import sjc.investFund.service.AreaService;
import sjc.investFund.service.BidService;
import sjc.investFund.service.ClaimService;
import sjc.investFund.service.CommentService;
import sjc.investFund.service.InvestorService;
import sjc.investFund.service.ProjectService;
import sjc.investFund.service.TransactionService;
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
	private ClaimService claimService;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private AreaService areaService;

	@Autowired
	private UserService userService;

	@Autowired
	private InvestorService investorService;

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

		return "project.details";
	}

	@RequestMapping(value = "/{id}/sendComment", method = RequestMethod.GET)
	public String addComment(@PathVariable("id") Project project,
			HttpSession session, Model model) {
		model.addAttribute("project", project);
		model.addAttribute("comment", new Comment());
		model.addAttribute("action");

		return "sendComment";
	}

	@RequestMapping(value = "/{id}/sendComment", method = RequestMethod.POST)
	public String addComment(@PathVariable("id") Project project,
			@ModelAttribute("comment") Comment comment,
			BindingResult bindingResult, Model model, HttpSession session,
			Authentication auth) {
		User user = userService.findByLogin(auth.getName());
				comment.setUser(user);
		comment.setProject(project);
		commentService.createComment(comment);
		model.asMap().remove("comment");
		String view = "infoSendingClaim";

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
			HttpSession session, Model model, Authentication auth) {
		User user = userService.findByLogin(auth.getName());
		claim.setUser(user);
		claim.setProject(project);
		claimService.createClaim(claim);
		model.asMap().remove("claim");
		String view = "infoSendingClaim";
		return view;
	}

	@RequestMapping(value = "/{id}/sendMoney", method = RequestMethod.GET)
	public String sendMoney(@PathVariable("id") Project project,
			HttpSession session, Model model) {
		model.addAttribute("project", project);
		model.addAttribute("transaction", new Transaction());
		model.addAttribute("action");
		
		return "sendMoney";
	}

	@RequestMapping(value = "/{id}/sendMoney", method = RequestMethod.POST)
	public String sendMoney(@PathVariable("id") Project project,
			@ModelAttribute("transaction") Transaction transaction,
			BindingResult bindingResult, HttpSession session, Model model,
			Authentication auth) {
		Investor investor = investorService.findByLogin(auth.getName());
		transaction.setInvestorAccount(investor.getAccount());
		transaction.setGoalAccount(project.getAccount());
		transactionService.saveTransaction(transaction);
		
		return "sendMoney";
	}

	@RequestMapping(value = "/{id}/sendMoney/datacheck", method = RequestMethod.GET)
	public String sendMoneyDatacheck(@PathVariable("id") Project project,
			HttpSession session, Model model) {
		model.addAttribute("project", project);

		return "sendMoney";
	}

	@RequestMapping(value = "/{id}/sendMoney/transfer", method = RequestMethod.GET)
	public String sendMoneyTransfer(@PathVariable("id") Project project,
			HttpSession session, Model model) {
		model.addAttribute("project", project);

		return "sendMoney";
	}

	@RequestMapping(value = "/{id}/sendMoney/bankcard", method = RequestMethod.GET)
	public String sendMoneyBankcard(@PathVariable("id") Project project,
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

	// andrew
	// @PreAuthorize("#p.user.login == a.name")
	@PreAuthorize("hasRole('ROLE_CREATOR')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editProject(@PathVariable("id") @P("p") Project project,
			HttpSession session, @P("a") Authentication auth, Model model) {

		model.addAttribute("arealist", areaService.getAreaMap());
		model.addAttribute("project", project);
		model.addAttribute("action", project.getId());

		return "bid";
	}

	@PreAuthorize("#p.user.login == #a.name")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String addBid(@ModelAttribute("project") @Valid Project project,
			BindingResult br, Authentication auth, Model model,
			@PathVariable("id") Integer id) {
		String view = "redirect:/projects/{id}";

		if (br.hasErrors()) {
			model.addAttribute("arealist", areaService.getAreaMap());
			view = "bid";
		} else {
			Project oldProject = projectService.getProjectById(id);
			oldProject.setArea(project.getArea());
			oldProject.setDeadline(project.getDeadline());
			oldProject.setDescription(project.getDescription());
			oldProject.setName(project.getName());
			oldProject.setRequiredAmount(project.getRequiredAmount());
			oldProject.setStatus(project.getStatus());
			projectService.updateProject(oldProject);
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

	// public void getAreaList(Model model) {
	// Map<String, String> areaList = new LinkedHashMap<String, String>();
	//
	// List<Area> areas = areaService.findAllAreas();
	// for (Area a : areas) {
	// areaList.put(a.getId().toString(), a.getName());
	// }
	// model.addAttribute("arealist", areaList);
	// }

	// andrew
	@RequestMapping(value = "/{id}/accept", method = RequestMethod.GET)
	public String acceptBid(@PathVariable("id") Project project, Model model) {
		Bid bid = bidService.getProjectBid(project);
		bidService.acceptBid(bid);
		return "redirect:/projects/{id}";
	}

	@RequestMapping(value = "/{id}/deny", method = RequestMethod.GET)
	public String denyBid(@PathVariable("id") Project project, Model model) {
		Bid bid = bidService.getProjectBid(project);
		bidService.denyBid(bid);
		return "redirect:/projects/{id}";
	}
}