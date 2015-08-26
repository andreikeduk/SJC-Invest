package sjc.investFund.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.ClaimDao;
import sjc.investFund.model.Claim;
import sjc.investFund.service.ClaimService;

@Service
@Transactional
public class ClaimServiceImpl implements ClaimService{
	@Autowired
	private ClaimDao claimRepository;

	@Override
	public void createClaim(Claim claim) {
		claimRepository.save(claim);
	}
}
