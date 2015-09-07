package sjc.investFund.domain.service;

import org.springframework.stereotype.Service;

import sjc.investFund.domain.model.Bankcard;

@Service
public interface BankcardService {
	void createBankcardTransaction(Bankcard bankcard);
}
