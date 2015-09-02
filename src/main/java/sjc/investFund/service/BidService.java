package sjc.investFund.service;

import java.util.List;

import sjc.investFund.controller.BidController;
import sjc.investFund.model.Area;
import sjc.investFund.model.Bid;
import sjc.investFund.model.BidStatus;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;

public interface BidService {
	void create(Bid bid);
	void delete(Bid bid);
	void update(Bid bid);
	void acceptBid(Bid bid);
	void denyBid(Bid bid);
	List<Bid> findAllBids();
	List<Bid> getBidsByUser(User user);
	List<Bid> findBidsByAreaStatus(Area area, BidStatus status);
	List<Bid> findBidsByStatus(BidStatus status);
	List<Bid> findBidsByArea(Area area);
	Bid getProjectBid(Project project);
}
