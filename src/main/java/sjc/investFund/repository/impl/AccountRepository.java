package sjc.investFund.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Account;
import sjc.investFund.domain.model.Transaction;
import sjc.investFund.repository.dao.AccountDao;
import sjc.investFund.repository.hibernate.AbstractHibernateDao;

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
