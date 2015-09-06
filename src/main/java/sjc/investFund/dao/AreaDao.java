package sjc.investFund.dao;

import java.util.List;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.Area;
import sjc.investFund.model.Bid;
import sjc.investFund.model.User;

public interface AreaDao extends GenericDao<Area, Integer> {
	Long getProjectsCount(Area area);
}
