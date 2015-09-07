package sjc.investFund.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Comment;
import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.model.User;
import sjc.investFund.repository.dao.CommentDao;
import sjc.investFund.repository.hibernate.AbstractHibernateDao;

@Transactional
@Repository()
public class CommentRepository extends AbstractHibernateDao<Comment, Integer>
implements CommentDao {
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentsByProject(Project project) {
		Criteria cr = getSession().createCriteria(Comment.class, "comments").add(Restrictions.eq("project", project));
		return (List<Comment>)cr.list();
	}
}
