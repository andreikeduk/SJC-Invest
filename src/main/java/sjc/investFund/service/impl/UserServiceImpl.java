package sjc.investFund.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.User;
import sjc.investFund.domain.service.UserService;
import sjc.investFund.repository.dao.UserDao;
import sjc.investFund.web.exception.AlredyExistException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userRepository;

	@Override
	public User findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public User findByLoginAndPassword(String login, String password) {
		return userRepository.findByLoginAndPassword(login, password);
	}

	@Override
	public void create(User user) throws AlredyExistException {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		if (findByLogin(user.getLogin()) != null) {
			throw new AlredyExistException("User with login '" + user.getLogin()
					+ "' alredy exist. Enter another login");
		} else {
			userRepository.save(user);
		}
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public void update(User oldUser, User newUser) throws AlredyExistException {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		newUser.setPassword(encoder.encode(newUser.getPassword()));
//		if (findByLogin(user.getLogin()) != null) {
//			throw new AlredyExistException("User with login '" + user.getLogin()
//					+ "' alredy exist. Enter another login");
//		} else {
		oldUser.setFirstName(newUser.getFirstName());
		oldUser.setLastName(newUser.getLastName());
		oldUser.setLogin(newUser.getLogin());
		oldUser.setPassword(newUser.getPassword());
		oldUser.setEmail(newUser.getEmail());
		userRepository.update(oldUser);
//		}
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

}
