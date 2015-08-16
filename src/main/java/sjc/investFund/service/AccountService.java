package sjc.investFund.service;
import org.springframework.stereotype.Service;
import sjc.investFund.model.Account;

@Service
public interface AccountService {
	public Account getAccountById(int id);
}
