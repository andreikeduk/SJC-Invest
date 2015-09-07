package sjc.investFund.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sjc.investFund.model.Comment;
import sjc.investFund.model.Project;
@Service
public interface CommentService {
	void createComment(Comment comment);
	List<Comment> getCommentsByProject(Project project);
}
