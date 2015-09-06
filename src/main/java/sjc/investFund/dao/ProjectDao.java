package sjc.investFund.dao;
import java.util.Calendar;
import java.util.List;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.Account;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;

public interface ProjectDao extends GenericDao<Project, Integer> {
	List<Project> findProjectsByUser(User user);
	Project findProjectsByName(String name);
	List<Project> findReadyProjects(Boolean status);
	List<Project> findOverdueProjects(Calendar date);
	Project findProjectByAccount(Account account);
}
