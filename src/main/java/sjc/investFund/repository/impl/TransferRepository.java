package sjc.investFund.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;





import sjc.investFund.domain.model.Transfer;
import sjc.investFund.repository.dao.TransferDao;
import sjc.investFund.repository.hibernate.AbstractHibernateDao;

@Transactional
@Repository()
public class TransferRepository extends AbstractHibernateDao<Transfer, Integer>
implements TransferDao {

}
