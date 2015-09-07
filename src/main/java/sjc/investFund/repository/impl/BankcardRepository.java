package sjc.investFund.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Bankcard;
import sjc.investFund.repository.dao.BankcardDao;
import sjc.investFund.repository.hibernate.AbstractHibernateDao;

@Transactional
@Repository()
public class BankcardRepository extends AbstractHibernateDao<Bankcard, Integer>
implements BankcardDao {

}
