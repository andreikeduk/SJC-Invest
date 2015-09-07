package sjc.investFund.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Account;
import sjc.investFund.domain.service.AccountService;
import sjc.investFund.repository.dao.AccountDao;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountRepository;

	@Override
	public Account getAccountById(int id) {
		return accountRepository.findById(id);
	}

	@Override
	public void update(Account account) {
		accountRepository.update(account);
	}

	@Override
	public Long getAccountBalance(Account acc) {
		return accountRepository.getAccountBalance(acc);
	}
}
