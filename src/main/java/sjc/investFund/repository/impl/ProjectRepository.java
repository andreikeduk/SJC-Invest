package sjc.investFund.repository.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Account;
import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.model.User;
import sjc.investFund.repository.dao.ProjectDao;
import sjc.investFund.repository.hibernate.AbstractHibernateDao;

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
	
	@Override
	public Project findProjectsByName(String name) {
		Criteria cr = getSession().createCriteria(Project.class, "projects").add(Restrictions.eq("name", name));
		return (Project)cr.uniqueResult();
	}
	
	@Override
	public Project findProjectByAccount(Account account) {
		Criteria cr = getSession().createCriteria(Project.class, "projects").add(Restrictions.eq("account", account));
		System.out.println(cr);
		return (Project)cr.uniqueResult();
	}
	/*
	 * @Autowired private DataSource ds;
	 * 
	 * public ProjectRepository() { }
	 * 
	 * public ProjectRepository(DataSource ds) { this.ds = ds; }
	 */

	@Override
	public List<Project> findReadyProjects(Boolean status) {
		Criteria cr = getSession().createCriteria(Project.class, "projects").add(Restrictions.eq("status", status));
		return (List<Project>)cr.list();
	}

	@Override
	public List<Project> findOverdueProjects(Calendar date) {
		// TODO Auto-generated method stub
		return null;
	}
}
