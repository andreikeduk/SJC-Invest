package sjc.investFund.service;
import java.util.List;

import org.springframework.stereotype.Service;

import freemarker.core.Comment;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;

@Service
public interface ProjectService {
	List<Project> findAllBids();
	void createProject(Project project);
	List<Project> findProjectsByUser(User user);
	Integer howManyMoney(Project project);
	
	public Project getProjectById(int id);
	void saveProject(Project project);
	void changeStatus(boolean status);
	
}
