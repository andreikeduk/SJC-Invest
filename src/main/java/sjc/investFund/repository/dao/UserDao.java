package sjc.investFund.repository.dao;

import sjc.investFund.domain.model.User;
import sjc.investFund.repository.base.GenericDao;

public interface UserDao extends GenericDao<User, Integer> {

	User findByLoginAndPassword(String login, String password);
	User findByLogin(String login);
}
