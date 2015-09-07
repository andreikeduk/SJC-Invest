package sjc.investFund.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sjc.investFund.domain.model.Mark;
import sjc.investFund.domain.model.Project;

@Service
public interface MarkService {
	void createMark(Mark mark);
	List<Mark> getMarksByProject(Project project);
}
