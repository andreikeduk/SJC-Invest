package sjc.investFund.service;

import java.util.List;

import sjc.investFund.model.User;

public interface UserService {
	User findByLoginAndPassword(String login, String password);
	User findByLogin(String login);
	User findById(Integer id);
	void create(User user);
	void delete(User user);
	void update(User user);
	List<User> findAllUsers();
}
