package sjc.investFund.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.BidDao;
import sjc.investFund.model.Area;
import sjc.investFund.model.Bid;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;
import sjc.investFund.repository.BidRepository;
import sjc.investFund.service.BidService;
@Service
@Transactional
public class BidServiceImpl implements BidService {
	@Autowired
	private BidDao bidRepository;
	
	@Override
	public void create(Bid bid) {
		bidRepository.save(bid);
	}

	@Override
	public void delete(Bid bid) {
		bidRepository.delete(bid);

	}

	@Override
	public void update(Bid bid) {
		bidRepository.update(bid);

	}

	@Override
	public List<Bid> findAllBids() {
		return bidRepository.findAll();
	}

	@Override
	public List<Bid> findBidsByUser(User user) {
		
		return null;
	}

	@Override
	public List<Bid> findBidsByArea(Area area) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bid getProjectBid(Project project) {
		return bidRepository.getProjectBid(project);
	}
	

}
