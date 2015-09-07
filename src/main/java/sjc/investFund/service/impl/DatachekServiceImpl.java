package sjc.investFund.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Account;
import sjc.investFund.domain.model.Datachek;
import sjc.investFund.domain.service.DatachekService;
import sjc.investFund.repository.dao.AccountDao;
import sjc.investFund.repository.dao.DatachekDao;

@Service
@Transactional
public class DatachekServiceImpl implements DatachekService {
	@Autowired
	private DatachekDao datachekRepository;
	
	@Autowired
	private AccountDao accountRepository;

	@Override
	public void createDatachek(Datachek datachek) {
		Account goalAcc = datachek.getGoalAccount();
		Account investorAcc = datachek.getInvestorAccount();
		
		goalAcc.setBalance(goalAcc.getBalance() + datachek.getAmount());
		investorAcc.setBalance(investorAcc.getBalance() - datachek.getAmount());
		
		accountRepository.update(goalAcc);
		accountRepository.update(investorAcc);
		
		datachekRepository.save(datachek);
	}

}
