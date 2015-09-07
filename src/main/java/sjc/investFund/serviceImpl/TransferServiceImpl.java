package sjc.investFund.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.AccountDao;
import sjc.investFund.dao.TransferDao;
import sjc.investFund.model.Account;
import sjc.investFund.model.Transfer;
import sjc.investFund.service.TransferService;

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
		
		transfer.setStatus(false);
		accountRepository.update(goalAcc);
		accountRepository.update(investorAcc);
		
		transferRepository.save(transfer);
	}

}
