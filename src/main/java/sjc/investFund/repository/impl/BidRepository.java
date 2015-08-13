package sjc.investFund.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import sjc.investFund.dao.BidDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Area;
import sjc.investFund.model.Bid;
import sjc.investFund.model.User;

public class BidRepository extends AbstractHibernateDao<Bid, Integer> implements
		BidDao {

//	@Override
//	public Bid createBid(User user){
//		return null;
//	}
	
	@Override
	public List<Bid> findUsersBid(User user) {
		
		return null;
	}

	@Override
	public List<Bid> findAreasBid(Area area) {
		
		return null;
	}

//	@Override
//	public Bid changeStatusBid(String status) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
