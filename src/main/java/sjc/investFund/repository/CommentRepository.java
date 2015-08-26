package sjc.investFund.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.CommentDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Comment;

@Transactional
@Repository()
public class CommentRepository extends AbstractHibernateDao<Comment, Integer>
implements CommentDao {

}
