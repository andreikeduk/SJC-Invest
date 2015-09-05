package sjc.investFund.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.DatachekDao;
import sjc.investFund.model.Datachek;
import sjc.investFund.service.DatachekService;

@Service
@Transactional
public class DatachekServiceImpl implements DatachekService {
	@Autowired
	private DatachekDao datachekRepository;

	@Override
	public void createDatachek(Datachek datachek) {
		datachekRepository.save(datachek);
	}

}
