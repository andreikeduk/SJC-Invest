package sjc.investFund.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.CommentDao;
import sjc.investFund.dao.PopularityDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Comment;
import sjc.investFund.model.Popularity;
import sjc.investFund.model.Project;

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
