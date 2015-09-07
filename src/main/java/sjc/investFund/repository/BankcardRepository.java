package sjc.investFund.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.BankcardDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Bankcard;

@Transactional
@Repository()
public class BankcardRepository extends AbstractHibernateDao<Bankcard, Integer>
implements BankcardDao {

}
