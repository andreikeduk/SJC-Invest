package sjc.investFund.dao;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.Account;
import sjc.investFund.model.Area;
import sjc.investFund.model.Project;

public interface AreaDao extends GenericDao<Area, Integer> {
	Long getProjectsCount(Area area);
	Area findAreaByAccount(Account account);
}
