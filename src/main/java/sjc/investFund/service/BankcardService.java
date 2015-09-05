package sjc.investFund.service;

import org.springframework.stereotype.Service;

import sjc.investFund.model.Bankcard;

@Service
public interface BankcardService {
	void createBankcardTransaction(Bankcard bankcard);
}
