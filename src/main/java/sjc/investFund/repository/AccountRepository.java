package sjc.investFund.repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.AccountDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Account;
import sjc.investFund.model.Transaction;

@Transactional
@Repository()
public class AccountRepository extends AbstractHibernateDao<Account, Integer>
implements AccountDao{
	@Override
	public Long getAccountBalance(Account acc) {
		Criteria cr = getSession()
				.createCriteria(Transaction.class, "transactions")
				.add(Restrictions.eq("goalAccount", acc))
				.setProjection(Projections.sum("amount"));
		return (Long)cr.uniqueResult();
	}
}
