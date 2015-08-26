package sjc.investFund.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
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
		Criteria criteria = getSession().createCriteria(Bid.class, "bids").add(
				Restrictions.eq("project", project));
		return (Bid) criteria.uniqueResult();
	}

	
	@Override
	public List<Bid> getBidsByUser(User user) {

//		List<Bid> bids = getSession()
//				.createQuery(
//						"from Bid as b left join b.project as p left join p.user as u where u = ? ")
//				.setEntity(0, user).list();
		

		 Criteria criteria = getSession().createCriteria(Bid.class, "Bids");
		 criteria.createAlias("project","bid_project",JoinType.LEFT_OUTER_JOIN);
		 criteria.createAlias("bid_project.user","project_user",JoinType.LEFT_OUTER_JOIN);
		 criteria.add(Restrictions.eq("project_user.login", user.getLogin()));
//		 criteria.setProjection(Projections.property("bids"));

		return (List<Bid>)criteria.list();
	}

}
