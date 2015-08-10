package sjc.investfund.andrew.service;

import java.util.List;

import sjc.investfund.andrew.domain.User;

public interface UserService{
	
	User findUserById(Integer id);
	
	List<User> usersList();
}
