package sjc.investFund.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sjc.investFund.domain.model.Comment;
import sjc.investFund.domain.model.Project;
@Service
public interface CommentService {
	void createComment(Comment comment);
	List<Comment> getCommentsByProject(Project project);
}
