package sjc.investFund.dao;

import java.util.List;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.Area;
import sjc.investFund.model.Bid;
import sjc.investFund.model.User;

public interface BidDao extends GenericDao<Bid, Integer> {
	//Bid createBid(User user);
	List<Bid> findUsersBid(User user);
	List<Bid> findAreasBid(Area area);
	//Bid changeStatusBid(String status);
}
