package sjc.investFund.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.investFund.dao.TransactionDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Account;
import sjc.investFund.model.Transaction;

@Repository
public class TransactionRepository extends AbstractHibernateDao<Transaction, Integer>
		implements TransactionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> findTransactionsOfAccount(Account acc) {
		Criteria cr = getSession().createCriteria(Transaction.class, "transactions").add(Restrictions.eq("goalAccount", acc));
		return (List<Transaction>)cr.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> findTransactionsOfInvestor(Account account) {
		Criteria cr = getSession().createCriteria(Transaction.class, "transactions").add(Restrictions.eq("investorAccount", account));
		return (List<Transaction>)cr.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getVerdictTransactions() {
		Criteria cr = getSession().createCriteria(Transaction.class, "transactions").add(Restrictions.eq("status", false));
		return (List<Transaction>)cr.list();
	}
}
