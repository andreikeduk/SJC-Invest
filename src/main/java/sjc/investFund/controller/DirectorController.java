package sjc.investFund.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.model.Area;
import sjc.investFund.model.BidStatus;
import sjc.investFund.model.Datachek;
import sjc.investFund.model.Project;
import sjc.investFund.model.Transaction;
import sjc.investFund.model.TypeTransaction;
import sjc.investFund.service.AreaService;
import sjc.investFund.service.BidService;
import sjc.investFund.service.CommentService;
import sjc.investFund.service.ProjectService;
import sjc.investFund.service.TransactionService;
import sjc.investFund.service.UserService;

@Controller
@RequestMapping("/director")
public class DirectorController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private UserService userService;

	@Autowired
	private BidService bidService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private AreaService areaService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ModelAndView directorRoom() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("director.room");
		mav.addObject("bidslist", bidService.findAllBids());
		return mav;
	}

	@PreAuthorize("hasRole('ROLE_DIRECTOR')")
	@RequestMapping(value = "/verdictTransactions", method = RequestMethod.GET)
	public ModelAndView sendMoneyFromArea(Model model) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("verdictTransactions");

		List<Project> projects = new ArrayList<Project>();
		List<Transaction> transactions = transactionService
				.getVerdictTransactions();
		List<Area> areas = new ArrayList<Area>();
		for (Transaction transaction : transactions) {
			Project p = projectService.findProjectByAccount(transaction
					.getGoalAccount());
			if (p != null) {
				projects.add(p);
			} else {
				Area a = areaService.findAreaByAccount(transaction
						.getGoalAccount());
				areas.add(a);
			}
		}
		mav.addObject("transactions", transactions);
		mav.addObject("projects", projects);
		mav.addObject("areas", areas);
		return mav;
	}

	@RequestMapping(value = "/transactions/{id}", method = RequestMethod.GET)
	public String showTransaction(@PathVariable("id") Transaction transaction,
			HttpSession session, Model model) {
		String returnTransaction = "";
		if (transaction.getType() == TypeTransaction.DATACHEK) {
			returnTransaction = "/transactions/{id}/datachek";
		} else if (transaction.getType() == TypeTransaction.BANKCARD) {
			returnTransaction = "/transactions/{id}/bankcard";
		} else {
			returnTransaction = "/transactions/{id}/transfer";
		}
		return returnTransaction;
	}
	
	@RequestMapping(value = "/transactions/{id}/datachek", method = RequestMethod.GET)
	public String showTransactionDatachek(@PathVariable("id") Datachek datachek,
			HttpSession session, Model model) {
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getAllBids() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("director.room");
		mav.addObject("bidslist", bidService.findAllBids());
		return mav;
	}

	@RequestMapping(value = "/accepted", method = RequestMethod.GET)
	public ModelAndView getAcceptedProjects() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("director.room");
		mav.addObject("bidslist",
				bidService.findBidsByStatus(BidStatus.ACCEPTED));
		return mav;
	}

	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public ModelAndView getDeniedProjects() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("director.room");
		mav.addObject("bidslist", bidService.findBidsByStatus(BidStatus.DENIED));
		return mav;
	}

	@RequestMapping(value = "/underconsideration", method = RequestMethod.GET)
	public ModelAndView getConsiderationProjects() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("director.room");
		mav.addObject("bidslist",
				bidService.findBidsByStatus(BidStatus.UNDER_CONSIDERATION));
		return mav;
	}

	@RequestMapping(value = "/ready", method = RequestMethod.GET)
	public ModelAndView getReadyProjects() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("director.projects");
		mav.addObject("projectslist", projectService.findReadyProjects(true));
		return mav;
	}

}
