package sjc.investFund.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.AccountDao;
import sjc.investFund.dao.TransactionDao;
import sjc.investFund.model.Account;
import sjc.investFund.model.Area;
import sjc.investFund.model.Project;
import sjc.investFund.model.Transaction;
import sjc.investFund.service.TransactionService;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionDao transactionRepository;
	

	@Override
	public void saveTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> findTransactionsOfProject(Project project) {
		return transactionRepository.findTransactionsOfAccount(project.getAccount());
	}

	@Override
	public List<Transaction> findTransactionsOfArea(Area area) {
		return transactionRepository.findTransactionsOfAccount(area.getAccount());
	}
}
