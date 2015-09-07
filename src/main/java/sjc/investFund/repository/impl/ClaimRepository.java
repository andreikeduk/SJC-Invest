package sjc.investFund.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Claim;
import sjc.investFund.repository.dao.ClaimDao;
import sjc.investFund.repository.hibernate.AbstractHibernateDao;

@Transactional
@Repository()
public class ClaimRepository extends AbstractHibernateDao<Claim, Integer>
implements ClaimDao{

}
