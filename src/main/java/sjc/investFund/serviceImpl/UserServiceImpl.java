package sjc.investFund.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.UserDao;
import sjc.investFund.model.User;
import sjc.investFund.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userRepository;

	@Override
	public User findByLoginAndPassword(String login,String password) {
		return userRepository.findByLoginAndPassword(login, password);
	}

	@Override
	public void create(User user) {
		userRepository.save(user);

	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	@Override
	public void update(User user) {
		userRepository.update(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

}
