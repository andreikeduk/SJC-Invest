package sjc.investFund.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sjc.investFund.domain.model.Popularity;
import sjc.investFund.domain.model.Project;

@Service
public interface PopularityService {
	void addLike(Popularity popularity);
	List<Popularity> getLikesByProject(Project project);
}
