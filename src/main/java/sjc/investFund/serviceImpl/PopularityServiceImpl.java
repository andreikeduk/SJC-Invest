package sjc.investFund.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.PopularityDao;
import sjc.investFund.model.Popularity;
import sjc.investFund.model.Project;
import sjc.investFund.service.PopularityService;

@Service
@Transactional
public class PopularityServiceImpl implements PopularityService {

	@Autowired
	private PopularityDao popularityRepository;

	@Override
	public void addLike(Popularity popularity) {
		popularityRepository.save(popularity);

	}

	@Override
	public List<Popularity> getLikesByProject(Project project) {
		return popularityRepository.getLikesByProject(project);
	}

}
