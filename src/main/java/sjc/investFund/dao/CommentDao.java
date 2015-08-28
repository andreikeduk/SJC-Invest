package sjc.investFund.dao;

import java.util.List;

import sjc.investFund.base.GenericDao;
import sjc.investFund.model.Comment;
import sjc.investFund.model.Project;

public interface CommentDao extends GenericDao<Comment, Integer> {
	List<Comment> getCommentsByProject(Project project);
}
