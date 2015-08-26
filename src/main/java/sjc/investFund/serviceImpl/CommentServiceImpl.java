package sjc.investFund.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.CommentDao;
import sjc.investFund.model.Comment;
import sjc.investFund.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao commentRepository;

	@Override
	public void createComment(Comment comment) {
		commentRepository.save(comment);
	}
}
