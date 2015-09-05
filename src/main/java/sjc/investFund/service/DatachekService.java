package sjc.investFund.service;

import org.springframework.stereotype.Service;

import sjc.investFund.model.Datachek;

@Service
public interface DatachekService {
	void createDatachek(Datachek datachek);
}
