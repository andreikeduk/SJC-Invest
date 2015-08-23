package sjc.investFund.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.AreaDao;
import sjc.investFund.model.Area;
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
	public Area findById(Integer id) {
		areaRepository.findById(id);
		return null;
	}

}
