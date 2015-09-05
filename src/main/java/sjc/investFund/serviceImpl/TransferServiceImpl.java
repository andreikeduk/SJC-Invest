package sjc.investFund.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.TransferDao;
import sjc.investFund.model.Transfer;
import sjc.investFund.service.TransferService;

@Service
@Transactional
public class TransferServiceImpl implements TransferService {
	@Autowired
	private TransferDao transferRepository;

	@Override
	public void createTransfer(Transfer transfer) {
		transferRepository.save(transfer);
	}

}
