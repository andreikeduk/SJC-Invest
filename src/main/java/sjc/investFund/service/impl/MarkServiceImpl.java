package sjc.investFund.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Mark;
import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.service.MarkService;
import sjc.investFund.repository.dao.MarkDao;

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
