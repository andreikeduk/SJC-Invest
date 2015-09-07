package sjc.investFund.domain.service;
import org.springframework.stereotype.Service;

import sjc.investFund.domain.model.Account;

@Service
public interface AccountService {
	void update(Account account);
	public Account getAccountById(int id);
	Long getAccountBalance(Account acc);
}
