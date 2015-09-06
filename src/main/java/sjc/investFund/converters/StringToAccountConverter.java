package sjc.investFund.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sjc.investFund.model.Account;
import sjc.investFund.service.AccountService;

@Component
public class StringToAccountConverter implements Converter<String, Account> {
	@Autowired
	private AccountService accountService;
     
    @Override
    public Account convert(String id) {
        return accountService.getAccountById(Integer.parseInt(id));
    }
}
