package sjc.investFund.repository.dao;

import java.util.List;

import sjc.investFund.domain.model.Mark;
import sjc.investFund.domain.model.Project;
import sjc.investFund.repository.base.GenericDao;

public interface MarkDao extends GenericDao<Mark, Integer>  {
	List<Mark> getMarksByProject(Project project);
}
