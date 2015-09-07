package sjc.investFund.domain.service;

import org.springframework.stereotype.Service;

import sjc.investFund.domain.model.Claim;

@Service
public interface ClaimService {
	void createClaim(Claim claim);
}
