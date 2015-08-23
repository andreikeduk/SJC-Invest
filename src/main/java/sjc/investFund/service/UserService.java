package sjc.investFund.service;

import java.util.List;

import sjc.investFund.model.User;

public interface UserService {
	User findByLogin(String login);
	void create(User user);
	void delete(User user);
	void update(User user);
	List<User> findAllUsers();
}
