package sjc.investFund.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.investFund.dao.BidDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Area;
import sjc.investFund.model.Bid;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;


@Repository
public class BidRepository extends AbstractHibernateDao<Bid, Integer> implements
		BidDao {

	@Override
	public Bid getProjectBid(Project project) {
		Criteria criteria = getSession().createCriteria(Bid.class, "bids").add(Restrictions.eq("project", project));
		return (Bid)criteria.uniqueResult();
	}

	@Override
	public List<Bid> getBidsByUser(User user) {
		Criteria criteria = getSession().createCriteria(Bid.class, "bids");
		criteria.createAlias("project", "bid_project");
		criteria.createAlias("user", "project_user");
		criteria.add(Restrictions.eq("project_user", user));
		return null;
	}

}
