package sjc.investFund.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Mark;
import sjc.investFund.domain.model.Project;
import sjc.investFund.repository.dao.MarkDao;
import sjc.investFund.repository.hibernate.AbstractHibernateDao;

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
