package sjc.investFund.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.TransactionDao;
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

}
