package sjc.investFund.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.ProjectDao;
import sjc.investFund.model.Project;
import sjc.investFund.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectRepository;

	@Override
	public Project getUserById(int id) {
		return projectRepository.findById(id);
	}
}
