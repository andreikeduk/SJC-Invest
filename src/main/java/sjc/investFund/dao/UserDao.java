package sjc.investFund.dao;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.User;

public interface UserDao extends GenericDao<User, Integer> {

	User findByLoginAndPassword(String login, String password);
	User findByLogin(String login);

//	void create(User user);
//
//	void delete(User user);
//
//	void update(User user);
//
//	List<User> findAllUsers();

}
