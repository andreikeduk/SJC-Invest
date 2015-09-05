package sjc.investFund.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.BankcardDao;
import sjc.investFund.model.Bankcard;
import sjc.investFund.service.BankcardService;

@Service
@Transactional
public class BankcardServiceImpl implements BankcardService {

	@Autowired
	private BankcardDao bankcardRepository;
	
	@Override
	public void createBankcardTransaction(Bankcard bankcard) {
		bankcardRepository.save(bankcard);
		
	}

}
