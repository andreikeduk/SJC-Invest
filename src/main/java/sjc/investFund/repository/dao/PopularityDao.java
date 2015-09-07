package sjc.investFund.repository.dao;

import java.util.List;

import sjc.investFund.domain.model.Popularity;
import sjc.investFund.domain.model.Project;
import sjc.investFund.repository.base.GenericDao;

public interface PopularityDao extends GenericDao<Popularity, Integer> {
	List<Popularity> getLikesByProject(Project project);
}
