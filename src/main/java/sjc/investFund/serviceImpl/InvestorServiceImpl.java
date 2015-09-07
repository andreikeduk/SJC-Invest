package sjc.investFund.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.InvestorDao;
import sjc.investFund.model.Investor;
import sjc.investFund.service.InvestorService;

@Service
@Transactional
public class InvestorServiceImpl implements InvestorService {

	@Autowired
	private InvestorDao investorRepository;

	@Override
	public Investor findByLogin(String login) {
		return investorRepository.findByLogin(login);
	}

}
