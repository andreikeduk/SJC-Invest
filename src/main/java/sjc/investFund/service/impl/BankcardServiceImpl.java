package sjc.investFund.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Account;
import sjc.investFund.domain.model.Bankcard;
import sjc.investFund.domain.service.BankcardService;
import sjc.investFund.repository.dao.AccountDao;
import sjc.investFund.repository.dao.BankcardDao;

@Service
@Transactional
public class BankcardServiceImpl implements BankcardService {

	@Autowired
	private BankcardDao bankcardRepository;
	
	@Autowired
	private AccountDao accountRepository;
	
	@Override
	public void createBankcardTransaction(Bankcard bankcard) {
		
		Account goalAcc = bankcard.getGoalAccount();
		Account investorAcc = bankcard.getInvestorAccount();
		
		goalAcc.setBalance(goalAcc.getBalance() + bankcard.getAmount());
		investorAcc.setBalance(investorAcc.getBalance() - bankcard.getAmount());
		
		accountRepository.update(goalAcc);
		accountRepository.update(investorAcc);
		
		bankcardRepository.save(bankcard);
		
	}

}
