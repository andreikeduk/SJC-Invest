package sjc.investFund.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import sjc.investFund.dao.UserDao;
import sjc.investFund.model.Role;
import sjc.investFund.model.User;
import sjc.investFund.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userRepository;

	@Override
	public User getUserByName(String userName) {
		User user = userRepository.findByName(userName);
		return user;
	}

	@Override
	public void createUser(User user, Role role) {

	}
}
