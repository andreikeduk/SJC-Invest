package sjc.investFund.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Investor;
import sjc.investFund.domain.service.InvestorService;
import sjc.investFund.repository.dao.InvestorDao;

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
