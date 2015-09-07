package sjc.investFund.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.investFund.domain.model.Investor;
import sjc.investFund.repository.dao.InvestorDao;
import sjc.investFund.repository.hibernate.AbstractHibernateDao;

@Repository
public class InvestorRepository extends AbstractHibernateDao<Investor, Integer>
		implements InvestorDao {

	@Override
	public Investor findByLogin(String login) {
		Criteria cr = getSession().createCriteria(Investor.class, "Users").add(
				Restrictions.eq("login", login));
		return (Investor) cr.uniqueResult();
	}

}
