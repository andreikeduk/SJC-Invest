package sjc.investFund.controller;

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

import sjc.investFund.model.Account;
import sjc.investFund.model.Bankcard;
import sjc.investFund.model.Datachek;
import sjc.investFund.model.Investor;
import sjc.investFund.model.Project;
import sjc.investFund.model.Transfer;
import sjc.investFund.service.BankcardService;
import sjc.investFund.service.DatachekService;
import sjc.investFund.service.InvestorService;
import sjc.investFund.service.TransferService;

@Controller
@RequestMapping(value = "/sendMoney/{id}")
public class TransactionController {

	@Autowired
	private InvestorService investorService;
	
	@Autowired
	private DatachekService datachekService;

	@Autowired
	private TransferService transferService;

	@Autowired
	private BankcardService bankcardService;

	private String view = "redirect:/redirector";

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String sendMoney(@PathVariable("id") Account account,
			HttpSession session, Model model) {

		model.addAttribute("account", account);
		return "sendMoney";

	}

	@RequestMapping(value = "/datachek", method = RequestMethod.GET)
	public String sendMoneyDatachek(@PathVariable("id") Account account,
			HttpSession session, Model model) {

		model.addAttribute("datachek", new Datachek());
		model.addAttribute("action");

		return "datachek";
	}

	@RequestMapping(value = "/datachek", method = RequestMethod.POST)
	public String sendMoneyDatachek(@PathVariable("id") Account account,
			@ModelAttribute("datachek") @Valid Datachek datachek,
			BindingResult bindingResult, HttpSession session, Model model,
			Authentication auth) {

		if (bindingResult.hasErrors()) {
			view = "datachek";
		} else {
			view = "redirect:/redirector";
			Investor investor = investorService.findByLogin(auth.getName());
			datachek.setInvestorAccount(investor.getAccount());
			datachek.setGoalAccount(account);
			datachekService.createDatachek(datachek);
			model.asMap().remove("datachek");
		}

		return view;
	}

	@RequestMapping(value = "/transfer", method = RequestMethod.GET)
	public String sendMoneyTransfer(@PathVariable("id") Account account,
			HttpSession session, Model model) {

		model.addAttribute("transfer", new Transfer());
		model.addAttribute("action");

		return "transfer";
	}

	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public String sendMoneyTransfer(@PathVariable("id") Account account,
			@ModelAttribute("transfer") @Valid Transfer transfer,
			BindingResult bindingResult, HttpSession session, Model model,
			Authentication auth) {

		if (bindingResult.hasErrors()) {
			view = "transfer";
		} else {
			view = "redirect:/projects/{id}";
			Investor investor = investorService.findByLogin(auth.getName());
			transfer.setInvestorAccount(investor.getAccount());
			transfer.setGoalAccount(account);
			transferService.createTransfer(transfer);
			model.asMap().remove("transfer");
		}

		return view;
	}

	@RequestMapping(value = "/bankcard", method = RequestMethod.GET)
	public String sendMoneyBankcard(@PathVariable("id") Account account,
			HttpSession session, Model model) {

		model.addAttribute("bankcard", new Bankcard());
		model.addAttribute("action");

		return "bankcard";
	}

	@RequestMapping(value = "/bankcard", method = RequestMethod.POST)
	public String sendMoneyBankcard(@PathVariable("id") Account account,
			@ModelAttribute("bankcard") @Valid Bankcard bankcard,
			BindingResult bindingResult, HttpSession session, Model model,
			Authentication auth) {

		if (bindingResult.hasErrors()) {
			view = "bankcard";
		} else {
			view = "redirect:/projects/{id}";
			Investor investor = investorService.findByLogin(auth.getName());
			bankcard.setInvestorAccount(investor.getAccount());
			bankcard.setGoalAccount(account);
			bankcardService.createBankcardTransaction(bankcard);
			model.asMap().remove("bankcard");
		}

		return view;
	}
}
