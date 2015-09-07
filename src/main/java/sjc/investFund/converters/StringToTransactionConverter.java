package sjc.investFund.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sjc.investFund.model.Project;
import sjc.investFund.model.Transaction;
import sjc.investFund.service.ProjectService;
import sjc.investFund.service.TransactionService;

@Component
public class StringToTransactionConverter implements Converter<String, Transaction>{
	@Autowired
	private TransactionService transactionService;
     
    @Override
    public Transaction convert(String id) {
        return transactionService.getTransactionById(Integer.parseInt(id));
    }
}