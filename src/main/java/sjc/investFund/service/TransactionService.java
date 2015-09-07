package sjc.investFund.service;
import java.util.List;

import org.springframework.stereotype.Service;

import sjc.investFund.model.Area;
import sjc.investFund.model.Investor;
import sjc.investFund.model.Project;
import sjc.investFund.model.Transaction;

@Service
public interface TransactionService {

	void saveTransaction(Transaction transaction);
	List<Transaction> findTransactionsOfProject(Project project);
	List<Transaction> findTransactionsOfArea(Area area);
	List<Transaction> findTransactionsOfInvestor(Investor investor);
	List<Transaction> getVerdictTransactions();
	Transaction getTransactionById(int parseInt);
}
