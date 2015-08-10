package sjc.investfund.andrew.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





import sjc.investfund.andrew.dao.UserDao;
import sjc.investfund.andrew.domain.User;
import sjc.investfund.andrew.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public User findUserById(Integer id) {
		return userDao.findUserById(id);
	}

	public List<User> usersList(){
		
		List<User> users = new ArrayList<User>();
		
		List<User> newUsers = userDao.findAll();
		for(User user : newUsers) {
			users.add(user);
		}
		
		return users;
	}
}
