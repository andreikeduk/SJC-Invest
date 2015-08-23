package sjc.investFund.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.investFund.dao.TransactionDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Account;
import sjc.investFund.model.Area;
import sjc.investFund.model.Project;
import sjc.investFund.model.Transaction;
import sjc.investFund.model.User;

@Repository
public class TransactionRepository extends AbstractHibernateDao<Transaction, Integer>
		implements TransactionDao {
		
	@Override
	public List<Transaction> projectTransactionsList(Project project) {
		 
		return null;
	}

	@Override
	public List<Transaction> userTransactionsList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> areaTransactionsList(Area area) {
		// TODO Auto-generated method stub
		return null;
	}

}
