package sjc.investFund.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.AccountDao;
import sjc.investFund.dao.DatachekDao;
import sjc.investFund.model.Account;
import sjc.investFund.model.Datachek;
import sjc.investFund.service.DatachekService;

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
