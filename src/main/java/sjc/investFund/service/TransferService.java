package sjc.investFund.service;

import org.springframework.stereotype.Service;

import sjc.investFund.model.Transfer;

@Service
public interface TransferService {
	void createTransfer(Transfer transfer);
}
