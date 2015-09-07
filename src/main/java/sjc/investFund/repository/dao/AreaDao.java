package sjc.investFund.repository.dao;

import sjc.investFund.domain.model.Area;
import sjc.investFund.repository.base.GenericDao;

public interface AreaDao extends GenericDao<Area, Integer> {
	Long getProjectsCount(Area area);
}
