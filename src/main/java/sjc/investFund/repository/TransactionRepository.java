package sjc.investFund.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.investFund.dao.TransactionDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Account;
import sjc.investFund.model.Area;
import sjc.investFund.model.Project;
import sjc.investFund.model.Transaction;
import sjc.investFund.model.User;

@Repository
public class TransactionRepository extends AbstractHibernateDao<Transaction, Integer>
		implements TransactionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> findTransactionsOfAccount(Account acc) {
		Criteria cr = getSession().createCriteria(Transaction.class, "transactions").add(Restrictions.eq("goalAccount", acc));
		return (List<Transaction>)cr.list();
	}
}
