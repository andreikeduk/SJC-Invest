package sjc.investFund.domain.service;

import org.springframework.stereotype.Service;

import sjc.investFund.domain.model.Transfer;

@Service
public interface TransferService {
	void createTransfer(Transfer transfer);
}
