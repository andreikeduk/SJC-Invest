package sjc.investFund.service;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Investor;
import sjc.investFund.model.User;

@Transactional
@Service
public class InvestorService extends AbstractHibernateDao<User, Integer> {
	@Override
	public Investor findById(Integer id) {
		Criteria cr = getSession().createCriteria(Investor.class, "Users")
				.add(Restrictions.eq("id", id));
		return (Investor) cr.uniqueResult();
	}
	
	

}
