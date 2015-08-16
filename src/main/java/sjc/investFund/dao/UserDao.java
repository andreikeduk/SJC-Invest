package sjc.investFund.dao;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.User;

public interface UserDao extends GenericDao<User, Integer> {
	User findByName(String name);
}
