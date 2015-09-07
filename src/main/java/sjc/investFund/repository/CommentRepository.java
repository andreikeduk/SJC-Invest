package sjc.investFund.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.CommentDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Comment;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;

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
