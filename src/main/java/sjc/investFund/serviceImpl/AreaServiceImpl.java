package sjc.investFund.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.AreaDao;
import sjc.investFund.model.Account;
import sjc.investFund.model.Area;
import sjc.investFund.model.Project;
import sjc.investFund.service.AreaService;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaDao areaRepository;

	@Override
	public void createArea(Area area) {
		areaRepository.save(area);

	}

	@Override
	public void deleteArea(Area area) {
		areaRepository.delete(area);
	}

	@Override
	public void updateArea(Area area) {
		areaRepository.update(area);
	}

	@Override
	public List<Area> findAllAreas() {
		return areaRepository.findAll();
	}

	@Override
	public Area findAreaById(Integer id) {
		return areaRepository.findById(id);
	}

	@Override
	public Map<String, String> getAreaMap() {
		Map<String, String> areaList = new HashMap<String, String>();

		List<Area> areas = findAllAreas();
		for (Area a : areas) {
			areaList.put(a.getId().toString(), a.getName());
		}
		return areaList;
	}

	@Override
	public Long getProjectsCount(Area area) {
		return areaRepository.getProjectsCount(area);
	}

	@Override
	public Area findAreaByAccount(Account account) {
		return areaRepository.findAreaByAccount(account);
	}

}
