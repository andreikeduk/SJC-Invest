package sjc.investFund.domain.service;
import java.util.List;

import org.springframework.stereotype.Service;

import sjc.investFund.domain.model.Area;
import sjc.investFund.domain.model.Investor;
import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.model.Transaction;

@Service
public interface TransactionService {

	void saveTransaction(Transaction transaction);
	List<Transaction> findTransactionsOfProject(Project project);
	List<Transaction> findTransactionsOfArea(Area area);
	List<Transaction> findTransactionsOfInvestor(Investor investor);
}
