package sjc.investfund.andrew.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.investfund.andrew.dao.UserDao;
import sjc.investfund.andrew.domain.User;
import sjc.investfund.andrew.repository.hibernate.AbstractHibernateDao;


@Repository
public class UserRepository extends AbstractHibernateDao<User, Integer> implements UserDao {

	@Override
	public User findUserById(Integer id) {
		Criteria cr = getSession()
				.createCriteria(User.class, "users")
				.add(Restrictions.eq("userId", id));
		return (User) cr.uniqueResult();
	}

}
