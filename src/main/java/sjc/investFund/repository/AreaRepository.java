package sjc.investFund.repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.investFund.dao.AreaDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Area;
import sjc.investFund.model.Project;
import sjc.investFund.model.Transaction;

@Repository
public class AreaRepository extends AbstractHibernateDao<Area, Integer>
		implements AreaDao {

	@Override
	public Long getProjectsCount(Area area) {
		Criteria cr = getSession().createCriteria(Project.class , "projects").add(Restrictions.eq("area", area)).setProjection(Projections.rowCount());
		return (Long)cr.uniqueResult();
	}
}
