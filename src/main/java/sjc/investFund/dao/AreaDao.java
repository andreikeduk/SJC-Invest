package sjc.investFund.dao;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.Area;

public interface AreaDao extends GenericDao<Area, Integer> {
	Long getProjectsCount(Area area);
}
