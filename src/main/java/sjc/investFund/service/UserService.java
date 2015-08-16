package sjc.investFund.service;

import sjc.investFund.model.Role;
import sjc.investFund.model.User;

public interface UserService {
	void createUser(User user, Role role);
	User getUserByName(String username);
}
