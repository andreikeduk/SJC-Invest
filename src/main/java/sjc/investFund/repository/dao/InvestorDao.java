package sjc.investFund.repository.dao;

import sjc.investFund.domain.model.Investor;
import sjc.investFund.repository.base.GenericDao;

public interface InvestorDao extends GenericDao<Investor, Integer> {
	Investor findByLogin(String login);
}
