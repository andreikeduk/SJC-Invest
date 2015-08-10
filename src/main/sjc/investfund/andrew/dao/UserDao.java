package sjc.investfund.andrew.dao;



import sjc.investfund.andrew.domain.User;
import sjc.investfund.andrew.repository.base.GenericDao;

public interface UserDao extends GenericDao<User, Integer> {
	//void addUser(User user);
	//void deleteUser(User user);
	//void deleteUserById(Integer id);
	//User findUser(User user);
	//List<User> usersList();
	User findUserById(Integer id);
}
