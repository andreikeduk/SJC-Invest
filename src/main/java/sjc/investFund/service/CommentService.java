package sjc.investFund.service;

import org.springframework.stereotype.Service;

import sjc.investFund.model.Comment;
@Service
public interface CommentService {
	void createComment(Comment comment);
}
