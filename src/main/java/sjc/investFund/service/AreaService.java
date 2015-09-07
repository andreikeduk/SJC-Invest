package sjc.investFund.service;

import java.util.List;
import java.util.Map;

import sjc.investFund.model.Account;
import sjc.investFund.model.Area;
import sjc.investFund.model.Project;

public interface AreaService {
	void createArea(Area area);
	void deleteArea(Area area);
	void updateArea(Area area);
	List<Area> findAllAreas();
	Area findAreaById(Integer id);
	Map<String, String> getAreaMap();
	Long getProjectsCount(Area area);
	Area findAreaByAccount(Account account);
}
