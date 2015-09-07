package sjc.investFund.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Account;
import sjc.investFund.domain.model.Transfer;
import sjc.investFund.domain.service.TransferService;
import sjc.investFund.repository.dao.AccountDao;
import sjc.investFund.repository.dao.TransferDao;

@Service
@Transactional
public class TransferServiceImpl implements TransferService {
	
	@Autowired
	private TransferDao transferRepository;
	
	@Autowired
	private AccountDao accountRepository;

	@Override
	public void createTransfer(Transfer transfer) {
		Account goalAcc = transfer.getGoalAccount();
		Account investorAcc = transfer.getInvestorAccount();
		
		goalAcc.setBalance(goalAcc.getBalance() + transfer.getAmount());
		investorAcc.setBalance(investorAcc.getBalance() - transfer.getAmount());
		
		accountRepository.update(goalAcc);
		accountRepository.update(investorAcc);
		
		transferRepository.save(transfer);
	}

}
