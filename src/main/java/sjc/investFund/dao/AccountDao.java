package sjc.investFund.dao;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.Account;

public interface AccountDao extends GenericDao<Account, Integer> {
	Long getAccountBalance(Account acc);
}
