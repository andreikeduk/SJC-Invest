package sjc.investFund.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.model.Area;
import sjc.investFund.model.Investor;
import sjc.investFund.model.Project;
import sjc.investFund.model.Transaction;
import sjc.investFund.service.AreaService;
import sjc.investFund.service.InvestorService;
import sjc.investFund.service.ProjectService;
import sjc.investFund.service.TransactionService;

@Controller
@RequestMapping("/investor")
public class InvestorController {
	@Autowired
	private InvestorService investorService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private AreaService areaService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ModelAndView investorRoom(HttpSession session, Authentication auth) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("investor.room");

		Investor investor = investorService.findByLogin(auth.getName());
		List<Project> projects = new ArrayList<Project>();
		List<Area> areas = new ArrayList<Area>();
		List<Transaction> transactions = transactionService
				.findTransactionsOfInvestor(investor);
		mav.addObject("investor", investor);
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
			// System.out.println(projects.get(flag));
		}
		mav.addObject("transactions", transactions);
		mav.addObject("projects", projects);
		mav.addObject("areas", areas);
		return mav;
	}
}
