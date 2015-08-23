package sjc.investFund.service;
import java.util.List;

import org.springframework.stereotype.Service;

import sjc.investFund.model.Project;
import sjc.investFund.model.User;

@Service
public interface ProjectService {
	public Project getUserById(int id);
	List<Project> findAllBids();
	void createProject(Project project);
	List<Project> findProjectsByUser(User user);
}
