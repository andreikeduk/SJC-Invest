package sjc.investFund.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.ClaimDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Claim;

@Transactional
@Repository()
public class ClaimRepository extends AbstractHibernateDao<Claim, Integer>
implements ClaimDao{

}
