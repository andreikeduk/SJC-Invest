package sjc.investFund.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.MarkDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Mark;
import sjc.investFund.model.Project;

@Transactional
@Repository()
public class MarkRepository extends AbstractHibernateDao<Mark, Integer>
implements MarkDao {

	@SuppressWarnings("unchecked")
	public List<Mark> getMarksByProject(Project project) {
		Criteria cr = getSession().createCriteria(Mark.class, "marks").add(Restrictions.eq("project", project));
		return (List<Mark>)cr.list();
	}

}
