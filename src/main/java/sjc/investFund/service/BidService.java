package sjc.investFund.service;

import java.util.List;

import sjc.investFund.model.Area;
import sjc.investFund.model.Bid;
import sjc.investFund.model.User;

public interface BidService {
	
	Bid createBid(User user);
	
	void updateBid(Bid bid);
	
	void deleteBid(Bid bid);

	List<Bid> findUsersBid(User user);

	List<Bid> findAreasBid(Area area);

	void changeStatusBid(String status);
}
