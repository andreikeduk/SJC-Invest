package sjc.investFund.repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.investFund.dao.InvestorDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Investor;

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
