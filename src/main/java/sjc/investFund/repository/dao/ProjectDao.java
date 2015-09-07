package sjc.investFund.repository.dao;
import java.util.Calendar;
import java.util.List;

import sjc.investFund.domain.model.Account;
import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.model.User;
import sjc.investFund.repository.base.GenericDao;

public interface ProjectDao extends GenericDao<Project, Integer> {
	List<Project> findProjectsByUser(User user);
	Project findProjectsByName(String name);
	List<Project> findReadyProjects(Boolean status);
	List<Project> findOverdueProjects(Calendar date);
	Project findProjectByAccount(Account account);
}
