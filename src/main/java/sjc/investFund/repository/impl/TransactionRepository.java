package sjc.investFund.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.investFund.domain.model.Account;
import sjc.investFund.domain.model.Transaction;
import sjc.investFund.repository.dao.TransactionDao;
import sjc.investFund.repository.hibernate.AbstractHibernateDao;

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
}
