package sjc.investFund.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sjc.investFund.model.Mark;
import sjc.investFund.model.Project;

@Service
public interface MarkService {
	void createMark(Mark mark);
	List<Mark> getMarksByProject(Project project);
}
