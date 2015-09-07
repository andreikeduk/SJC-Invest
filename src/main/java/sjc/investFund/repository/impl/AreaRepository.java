package sjc.investFund.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.investFund.domain.model.Area;
import sjc.investFund.domain.model.Project;
import sjc.investFund.repository.dao.AreaDao;
import sjc.investFund.repository.hibernate.AbstractHibernateDao;

@Repository
public class AreaRepository extends AbstractHibernateDao<Area, Integer>
		implements AreaDao {

	@Override
	public Long getProjectsCount(Area area) {
		Criteria cr = getSession().createCriteria(Project.class, "projects")
				.add(Restrictions.eq("area", area))
				.setProjection(Projections.rowCount());
		return (Long) cr.uniqueResult();
	}
}
