package sjc.investFund.service;

import java.util.List;

import sjc.investFund.exception.AlredyExistException;
import sjc.investFund.model.User;

public interface UserService {
	User findByLoginAndPassword(String login, String password);
	User findByLogin(String login);
	User findById(Integer id);
	void create(User user) throws AlredyExistException;
	void delete(User user);
	void update(User oldUser, User newUser) throws AlredyExistException;
	List<User> findAllUsers();
}
