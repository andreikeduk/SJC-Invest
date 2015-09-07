package sjc.investFund.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Comment;
import sjc.investFund.domain.model.Popularity;
import sjc.investFund.domain.model.Project;
import sjc.investFund.repository.dao.CommentDao;
import sjc.investFund.repository.dao.PopularityDao;
import sjc.investFund.repository.hibernate.AbstractHibernateDao;

@Transactional
@Repository()
public class PopularityRepository extends AbstractHibernateDao<Popularity, Integer>
implements PopularityDao {

	@SuppressWarnings("unchecked")
	public List<Popularity> getLikesByProject(Project project) {
		Criteria cr = getSession().createCriteria(Popularity.class, "popularities").add(Restrictions.eq("project", project));
		return (List<Popularity>)cr.list();
	}

}
