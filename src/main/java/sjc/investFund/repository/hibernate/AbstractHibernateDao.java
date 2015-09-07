package sjc.investFund.repository.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjc.investFund.repository.base.GenericDao;

@Repository
public abstract class AbstractHibernateDao<T, PK extends Serializable> implements GenericDao<T, PK> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	protected Class<T> getGenericEntityClass() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	
	@Override
	public void save(T obj) {
		getSession().save(obj);
	}

	@Override
	public void update(T obj) {
		getSession().update(obj);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Criteria cr = getSession().createCriteria(this.getGenericEntityClass());
		return (List<T>) cr.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(PK id) {
		return (T) getSession().get(this.getGenericEntityClass(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(PK id) {
		T persistentObject = (T) getSession().load(this.getGenericEntityClass(), id);
		try {
			getSession().delete(persistentObject);
		} catch (NonUniqueObjectException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(T persistentObject) {
		try {
			getSession().delete(persistentObject);
		} catch (NonUniqueObjectException e) {
			e.printStackTrace();
		}
	}
}
