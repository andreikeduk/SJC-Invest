package sjc.investFund.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.ProjectDao;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;
import sjc.investFund.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectRepository;

	@Override
	public Project getProjectById(int id) {
		return projectRepository.findById(id);
	}

	@Override
	public List<Project> findAllBids() {
		return projectRepository.findAll();
	}

	@Override
	public void createProject(Project project) {
		projectRepository.save(project);
		
	}

	@Override
	public List<Project> findProjectsByUser(User user) {
		return projectRepository.findProjectsByUser(user);
	}

	@Override
	public Integer howManyMoney(Project project) {
		
		return project.getAccount().getBalance();
	}
	
	@Override
	public void changeStatus(boolean status) {	
	}

	@Override
	public void updateProject(Project project) {
		projectRepository.update(project);
	}
	
	
}
