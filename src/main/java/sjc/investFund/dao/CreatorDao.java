package sjc.investFund.dao;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.Bid;
import sjc.investFund.model.User;

public interface CreatorDao extends GenericDao<User, Integer> {
	User findCreatorOfBid(Bid bid);
}
