package sjc.investFund.repository.dao;

import java.util.List;

import sjc.investFund.domain.model.Account;
import sjc.investFund.domain.model.Transaction;
import sjc.investFund.repository.base.GenericDao;

public interface TransactionDao extends GenericDao<Transaction, Integer> {
	List<Transaction> findTransactionsOfAccount(Account acc);
	List<Transaction> findTransactionsOfInvestor(Account account);
}
