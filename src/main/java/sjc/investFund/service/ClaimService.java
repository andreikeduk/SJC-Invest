package sjc.investFund.service;

import org.springframework.stereotype.Service;

import sjc.investFund.model.Claim;

@Service
public interface ClaimService {
	void createClaim(Claim claim);
}
