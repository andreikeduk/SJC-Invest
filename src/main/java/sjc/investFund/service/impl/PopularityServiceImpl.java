package sjc.investFund.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Popularity;
import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.service.PopularityService;
import sjc.investFund.repository.dao.PopularityDao;

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
