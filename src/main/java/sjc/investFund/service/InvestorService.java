package sjc.investFund.service;

import sjc.investFund.model.Investor;

public interface InvestorService {
	Investor findByLogin(String login);
}
