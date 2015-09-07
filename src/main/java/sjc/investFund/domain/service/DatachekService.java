package sjc.investFund.domain.service;

import org.springframework.stereotype.Service;

import sjc.investFund.domain.model.Datachek;

@Service
public interface DatachekService {
	void createDatachek(Datachek datachek);
}
