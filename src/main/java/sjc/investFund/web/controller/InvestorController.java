package sjc.investFund.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjc.investFund.domain.model.Investor;
import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.model.Transaction;
import sjc.investFund.domain.model.User;
import sjc.investFund.domain.service.BidService;
import sjc.investFund.domain.service.InvestorService;
import sjc.investFund.domain.service.ProjectService;
import sjc.investFund.domain.service.TransactionService;
import sjc.investFund.domain.service.TransferService;
import sjc.investFund.domain.service.UserService;

@Controller
@RequestMapping("/investor")
public class InvestorController {
	@Autowired
	private InvestorService investorService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TransactionService transactionService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ModelAndView investorRoom(HttpSession session, Authentication auth) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("investor.room");

		Investor investor = investorService.findByLogin(auth.getName());
		List<Project> projects = new ArrayList<Project>();
		List<Transaction> transactions = transactionService
				.findTransactionsOfInvestor(investor);
		int flag = 0;
		for (Transaction transaction : transactions) {
			projects.add(flag, projectService.findProjectByAccount(transaction
					.getGoalAccount()));
		}
		
		System.out.println(projects.get(0).getName());
		mav.addObject("transactions", transactions);
		mav.addObject("projects", projects);
		return mav;
	}
}
