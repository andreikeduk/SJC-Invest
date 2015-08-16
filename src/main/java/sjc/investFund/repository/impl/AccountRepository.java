package sjc.investFund.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sjc.investFund.dao.AccountDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Account;

@Transactional
@Repository()
public class AccountRepository extends AbstractHibernateDao<Account, Integer>
implements AccountDao{

}
