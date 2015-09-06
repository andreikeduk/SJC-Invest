package sjc.investFund.repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.investFund.dao.UserDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.User;

@Repository
public class UserRepository extends AbstractHibernateDao<User, Integer>
		implements UserDao {

	@Override
	public User findByLoginAndPassword(String login, String password) {
		Criteria cr = getSession().createCriteria(User.class, "users")
				.add(Restrictions.eq("login", login)).add(Restrictions.eq("password", password));
		return (User) cr.uniqueResult();
	}
	@Override
	public User findByLogin(String login) {
		Criteria cr = getSession().createCriteria(User.class, "users")
				.add(Restrictions.eq("login", login));
		return (User) cr.uniqueResult();
	}
}
