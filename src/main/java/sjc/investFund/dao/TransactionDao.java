package sjc.investFund.dao;

import java.util.List;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.Account;
import sjc.investFund.model.Transaction;

public interface TransactionDao extends GenericDao<Transaction, Integer> {
	List<Transaction> findTransactionsOfAccount(Account acc);
	List<Transaction> findTransactionsOfInvestor(Account account);
	List<Transaction> getVerdictTransactions();
}
