package sjc.investFund.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import sjc.investFund.dao.BidDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Area;
import sjc.investFund.model.Bid;
import sjc.investFund.model.BidStatus;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;

@Repository
public class BidRepository extends AbstractHibernateDao<Bid, Integer> implements
		BidDao {

	@Override
	public Bid getProjectBid(Project project) {
		Criteria criteria = getSession().createCriteria(Bid.class, "bids").add(
				Restrictions.eq("project", project));
		return (Bid) criteria.uniqueResult();
	}

	@Override
	public List<Bid> getBidsByUser(User user) {

		Criteria criteria = getSession().createCriteria(Bid.class, "Bids");
		criteria.createAlias("project", "bid_project", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("bid_project.user", "project_user",
				JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("project_user.id", user.getId()));
		// criteria.setProjection(Projections.property("bids"));

		return (List<Bid>) criteria.list();
	}

	@Override
	public List<Bid> getBidsByAreaStatus(Area area, BidStatus status) {
		Criteria criteria = getSession().createCriteria(Bid.class, "Bids");
		criteria.add(Restrictions.eq("Bids.status", status));
		criteria.createAlias("project", "bid_project", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("bid_project.area", "project_area",
				JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("project_area.id", area.getId()));
		return (List<Bid>) criteria.list();
	}

	@Override
	public List<Bid> getBidsByArea(Area area) {
		Criteria criteria = getSession().createCriteria(Bid.class, "Bids");
		criteria.createAlias("project", "bid_project", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("bid_project.area", "project_area",
				JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("project_area.id", area.getId()));
		return (List<Bid>) criteria.list();
	}

	@Override
	public List<Bid> getBidsByStatus(BidStatus status) {
		Criteria criteria = getSession().createCriteria(Bid.class, "Bids");
		criteria.add(Restrictions.eq("Bids.status", status));
		return (List<Bid>) criteria.list();
	}
}
