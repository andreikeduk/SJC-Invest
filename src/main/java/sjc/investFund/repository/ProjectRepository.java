package sjc.investFund.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.ProjectDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;

@Transactional
@Repository()
public class ProjectRepository extends AbstractHibernateDao<Project, Integer>
		implements ProjectDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findProjectsByUser(User user) {
		Criteria cr = getSession().createCriteria(Project.class, "projects").add(Restrictions.eq("user", user));
		return (List<Project>)cr.list();
	}
	/*
	 * @Autowired private DataSource ds;
	 * 
	 * public ProjectRepository() { }
	 * 
	 * public ProjectRepository(DataSource ds) { this.ds = ds; }
	 */
	
	
}
