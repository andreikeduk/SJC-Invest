package sjc.investFund.domain.service;

import java.util.List;

import sjc.investFund.domain.model.Area;
import sjc.investFund.domain.model.Bid;
import sjc.investFund.domain.model.BidStatus;
import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.model.User;
import sjc.investFund.web.controller.BidController;

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
