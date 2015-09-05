package sjc.investFund.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.dao.DatachekDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Datachek;

@Transactional
@Repository()
public class DatachekRepository extends AbstractHibernateDao<Datachek, Integer>
implements DatachekDao {

}
