package sjc.investFund.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Claim;
import sjc.investFund.domain.service.ClaimService;
import sjc.investFund.repository.dao.ClaimDao;

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
