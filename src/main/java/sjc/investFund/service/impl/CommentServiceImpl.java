package sjc.investFund.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Comment;
import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.service.CommentService;
import sjc.investFund.repository.dao.CommentDao;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao commentRepository;

	@Override
	public void createComment(Comment comment) {
		commentRepository.save(comment);
	}

	@Override
	public List<Comment> getCommentsByProject(Project project) {
		return commentRepository.getCommentsByProject(project);
	}
}
