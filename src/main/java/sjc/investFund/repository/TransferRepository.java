package sjc.investFund.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import sjc.investFund.dao.TransferDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Transfer;

@Transactional
@Repository()
public class TransferRepository extends AbstractHibernateDao<Transfer, Integer>
implements TransferDao {

}
