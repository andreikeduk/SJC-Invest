package sjc.investFund.repository.base;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
	
	void save(T obj);
	
	void update(T obj);
	
	List<T> findAll();
	
	T findById(PK id);
	
	void delete(PK id);
	
	void delete(T persistentObject);
}
