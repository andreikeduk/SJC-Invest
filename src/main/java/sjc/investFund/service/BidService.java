package sjc.investFund.service;

import java.util.List;

import sjc.investFund.model.Area;
import sjc.investFund.model.Bid;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;

public interface BidService {
	void create(Bid bid);
	void delete(Bid bid);
	void update(Bid bid);
	List<Bid> findAllBids();
	List<Bid> findBidsByUser(User user);
	List<Bid> findBidsByArea(Area area);
	Bid getProjectBid(Project project);
}
