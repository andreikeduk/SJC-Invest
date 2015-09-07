package sjc.investFund.repository.dao;

import sjc.investFund.domain.model.Account;
import sjc.investFund.repository.base.GenericDao;

public interface AccountDao extends GenericDao<Account, Integer> {
	Long getAccountBalance(Account acc);
}
