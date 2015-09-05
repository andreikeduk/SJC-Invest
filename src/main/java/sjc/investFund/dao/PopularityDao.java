package sjc.investFund.dao;

import java.util.List;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.Popularity;
import sjc.investFund.model.Project;

public interface PopularityDao extends GenericDao<Popularity, Integer> {
	List<Popularity> getLikesByProject(Project project);
}
