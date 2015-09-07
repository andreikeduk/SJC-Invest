package sjc.investFund.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Account;
import sjc.investFund.domain.model.Area;
import sjc.investFund.domain.model.Investor;
import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.model.Transaction;
import sjc.investFund.domain.service.TransactionService;
import sjc.investFund.repository.dao.AccountDao;
import sjc.investFund.repository.dao.TransactionDao;

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
	
	@Override
	public List<Transaction> findTransactionsOfInvestor(Investor investor) {
		return transactionRepository.findTransactionsOfInvestor(investor.getAccount());
	}
}
