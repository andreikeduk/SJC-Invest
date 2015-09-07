package sjc.investFund.repository.dao;

import java.util.List;

import sjc.investFund.domain.model.Area;
import sjc.investFund.domain.model.Bid;
import sjc.investFund.domain.model.BidStatus;
import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.model.User;
import sjc.investFund.repository.base.GenericDao;

public interface BidDao extends GenericDao<Bid, Integer> {
	Bid getProjectBid(Project project);
	List<Bid> getBidsByUser(User user); 
	List<Bid> getBidsByAreaStatus(Area area, BidStatus status);
	List<Bid> getBidsByArea(Area area);
	List<Bid> getBidsByStatus(BidStatus status);
}
