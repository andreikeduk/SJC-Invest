package sjc.investFund.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.AccountDao;
import sjc.investFund.dao.BankcardDao;
import sjc.investFund.model.Account;
import sjc.investFund.model.Bankcard;
import sjc.investFund.service.BankcardService;

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
		
		bankcard.setStatus(false);
		accountRepository.update(goalAcc);
		accountRepository.update(investorAcc);
		
		bankcardRepository.save(bankcard);
		
	}

}
