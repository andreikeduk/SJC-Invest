package sjc.investFund.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sjc.investFund.model.Popularity;
import sjc.investFund.model.Project;

@Service
public interface PopularityService {
	void addLike(Popularity popularity);
	List<Popularity> getLikesByProject(Project project);
}
