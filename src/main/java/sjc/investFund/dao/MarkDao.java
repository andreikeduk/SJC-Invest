package sjc.investFund.dao;

import java.util.List;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.Mark;
import sjc.investFund.model.Project;

public interface MarkDao extends GenericDao<Mark, Integer>  {
	List<Mark> getMarksByProject(Project project);
}
