package sjc.investFund.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import freemarker.core.Comment;
import sjc.investFund.domain.model.Account;
import sjc.investFund.domain.model.Bid;
import sjc.investFund.domain.model.BidStatus;
import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.model.User;
import sjc.investFund.domain.service.ProjectService;
import sjc.investFund.repository.dao.BidDao;
import sjc.investFund.repository.dao.ProjectDao;
import sjc.investFund.web.exception.AlredyExistException;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectRepository;
	@Autowired
	private BidDao bidRepository;

	@Override
	public Project getProjectById(int id) {
		return projectRepository.findById(id);
	}

	@Override
	public List<Project> findAllBids() {
		return projectRepository.findAll();
	}
	
	@Override
	public void createProject(Project project, User user) throws AlredyExistException {
		if (findProjectByName(project.getName()) != null) {
			throw new AlredyExistException("Project with name '"
					+ project.getName() + "'alredy exist. Choose Another name");
		} else {
			Account acc = generateAccount();
			project.setAccount(acc);
			project.setUser(user);
			Bid bid = new Bid(BidStatus.UNDER_CONSIDERATION);
			bid.setProject(project);
			bidRepository.save(bid);
			projectRepository.save(project);
		}
	}	

	@Override
	public List<Project> findProjectsByUser(User user) {
		return projectRepository.findProjectsByUser(user);
	}

	@Override
	public void updateProject(Project oldProject, Project newProject) throws AlredyExistException {
			oldProject.setArea(newProject.getArea());
			oldProject.setDeadline(newProject.getDeadline());
			oldProject.setDescription(newProject.getDescription());
			oldProject.setName(newProject.getName());
			oldProject.setRequiredAmount(newProject.getRequiredAmount());
			oldProject.setStatus(newProject.getStatus());
			projectRepository.update(oldProject);		
	}

	@Override
	public Calendar getExpirationDate(Project project) {
		Calendar expirationDate = null;
		Bid bid = bidRepository.getProjectBid(project);
		if (bid.getStatus().equals(BidStatus.ACCEPTED)) {
			expirationDate = bid.getPeriodConsideration();
			expirationDate.add(Calendar.DATE, project.getDeadline());
		}
		return expirationDate;
	}

	@Override
	public Project findProjectByName(String name) {
		return projectRepository.findProjectsByName(name);
	}

	@Override
	public List<Project> findReadyProjects(Boolean status) {
		return projectRepository.findReadyProjects(true);
	}
	
	@Override
	public Project findProjectByAccount(Account account) {
		return projectRepository.findProjectByAccount(account);
	}
	
	private Account generateAccount() {
		Integer number = 1000000 + (int) (Math.random() * 1000);
		Account acc = new Account();
		acc.setNumber(number);
		return acc;
	}

}
