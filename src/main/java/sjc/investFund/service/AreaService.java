package sjc.investFund.service;

import java.util.List;

import sjc.investFund.model.Area;

public interface AreaService {
	void createArea(Area area);
	void deleteArea(Area area);
	void updateArea(Area area);
	List<Area> findAllAreas();
	Area findAreaById(Integer id);
}
