package sjc.investFund.repository;

import org.springframework.stereotype.Repository;

import sjc.investFund.dao.AreaDao;
import sjc.investFund.hibernate.AbstractHibernateDao;
import sjc.investFund.model.Area;
@Repository
public class AreaRepository extends AbstractHibernateDao<Area, Integer> implements AreaDao {

}
