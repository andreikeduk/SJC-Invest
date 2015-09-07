package sjc.investFund.dao;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.Investor;

public interface InvestorDao extends GenericDao<Investor, Integer> {
	Investor findByLogin(String login);
}
