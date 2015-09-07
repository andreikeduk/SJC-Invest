package sjc.investFund.repository.dao;

import java.util.List;

import sjc.investFund.domain.model.Comment;
import sjc.investFund.domain.model.Project;
import sjc.investFund.repository.base.GenericDao;

public interface CommentDao extends GenericDao<Comment, Integer> {
	List<Comment> getCommentsByProject(Project project);
}
