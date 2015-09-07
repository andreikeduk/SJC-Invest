package sjc.investFund.domain.service;

import sjc.investFund.domain.model.Investor;

public interface InvestorService {
	Investor findByLogin(String login);
}
