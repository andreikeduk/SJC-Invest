package sjc.investFund.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.domain.model.Datachek;
import sjc.investFund.repository.dao.DatachekDao;
import sjc.investFund.repository.hibernate.AbstractHibernateDao;

@Transactional
@Repository()
public class DatachekRepository extends AbstractHibernateDao<Datachek, Integer>
implements DatachekDao {

}
