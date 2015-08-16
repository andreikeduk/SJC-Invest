package sjc.investFund.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sjc.investFund.dao.ProjectDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Project;

@Transactional
@Repository()
public class ProjectRepository extends AbstractHibernateDao<Project, Integer>
		implements ProjectDao {
	/*
	 * @Autowired private DataSource ds;
	 * 
	 * public ProjectRepository() { }
	 * 
	 * public ProjectRepository(DataSource ds) { this.ds = ds; }
	 */
}
