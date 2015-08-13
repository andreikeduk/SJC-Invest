package sjc.investFund.dao;

import java.util.List;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.Account;
import sjc.investFund.model.Area;
import sjc.investFund.model.Project;
import sjc.investFund.model.Transaction;
import sjc.investFund.model.User;

public interface TransactionDao extends GenericDao<Transaction, Integer> {
	
	List<Transaction> projectTransactionsList(Project project);
	List<Transaction> userTransactionsList(User user);
	List<Transaction> areaTransactionsList(Area area);
}
