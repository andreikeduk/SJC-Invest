package sjc.investFund.domain.service;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import freemarker.core.Comment;
import sjc.investFund.domain.model.Account;
import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.model.User;
import sjc.investFund.web.exception.AlredyExistException;

@Service
public interface ProjectService {
	List<Project> findAllBids();
	List<Project> findProjectsByUser(User user);
	Project findProjectByName(String name);
	public Project getProjectById(int id);
	void createProject(Project project, User user) throws AlredyExistException;
	void updateProject(Project oldProject, Project newProject) throws AlredyExistException;
	Calendar getExpirationDate(Project project);
	List<Project> findReadyProjects(Boolean status);
	Project findProjectByAccount(Account account);
	
}
