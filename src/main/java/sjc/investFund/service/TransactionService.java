package sjc.investFund.service;
import java.util.List;

import sjc.investFund.model.Project;
import sjc.investFund.model.Transaction;

public interface TransactionService {

	void saveTransaction(Transaction transaction);
	List<Transaction> findTransactionsOfProject(Project project);
	
}
