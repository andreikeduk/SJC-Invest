package sjc.investFund.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import sjc.investFund.dao.CreatorDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Bid;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;

public class CreatorRepository extends AbstractHibernateDao<User, Integer> implements
		CreatorDao {
	@Override
	public User findCreatorOfBid(Bid bid) {
		return null;
	}

}
