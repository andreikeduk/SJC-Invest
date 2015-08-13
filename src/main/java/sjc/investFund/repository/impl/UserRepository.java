package sjc.investFund.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.investFund.dao.UserDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.User;

@Repository
public class UserRepository extends AbstractHibernateDao<User, Integer> implements
		UserDao {
	
	@Override
	public User findUserByName(String name) {
		Criteria cr = getSession().createCriteria(User.class, "Users").add(Restrictions.eq("firstName", name));
		return (User)cr.uniqueResult();
	}
	
}
