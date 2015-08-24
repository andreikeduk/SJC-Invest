package sjc.investFund.service;


import sjc.investFund.model.Area;
import sjc.investFund.model.Project;
import sjc.investFund.model.Transaction;

public interface TransactionService {
//	Integer howManyMoney(Area area);
//	Integer howManyMoney(Project project);
	void saveTransaction(Transaction transaction);
}
