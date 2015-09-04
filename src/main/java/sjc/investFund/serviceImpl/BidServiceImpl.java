package sjc.investFund.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.BidDao;
import sjc.investFund.dao.ProjectDao;
import sjc.investFund.model.Area;
import sjc.investFund.model.Bid;
import sjc.investFund.model.BidStatus;
import sjc.investFund.model.Project;
import sjc.investFund.model.User;
import sjc.investFund.service.BidService;

@Service
@Transactional
public class BidServiceImpl implements BidService {
	@Autowired
	private BidDao bidRepository;
	@Autowired
	private ProjectDao projectRepository;

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
	public Bid getProjectBid(Project project) {
		return bidRepository.getProjectBid(project);
	}
	@Override
	public List<Bid> getBidsByUser(User user){
		return bidRepository.getBidsByUser(user);
	}

	@Override
	public List<Bid> findBidsByAreaStatus(Area area, BidStatus status) {
		return bidRepository.getBidsByAreaStatus(area, status);
	}
	@Override
	public List<Bid> findBidsByStatus(BidStatus status) {
		return bidRepository.getBidsByStatus(status);
	}

	@Override
	public List<Bid> findBidsByArea(Area area) {
		return bidRepository.getBidsByArea(area);
	}

	@Override
	public void acceptBid(Bid bid) {		
		bid.setStatus(BidStatus.ACCEPTED);
		bid.setPeriodConsideration(Calendar.getInstance());	
		bidRepository.update(bid);
	}

	@Override
	public void denyBid(Bid bid) {
		bid.setStatus(BidStatus.DENIED);
		bid.setPeriodConsideration(Calendar.getInstance());	
		bidRepository.update(bid);
	}

	
	

}
