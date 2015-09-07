package sjc.investFund.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.MarkDao;
import sjc.investFund.model.Mark;
import sjc.investFund.model.Project;
import sjc.investFund.service.MarkService;

@Service
@Transactional
public class MarkServiceImpl implements MarkService {

	@Autowired
	private MarkDao markRepository;
	
	@Override
	public void createMark(Mark mark) {
		markRepository.save(mark);

	}

	@Override
	public List<Mark> getMarksByProject(Project project) {
		return markRepository.getMarksByProject(project);
	}

}
