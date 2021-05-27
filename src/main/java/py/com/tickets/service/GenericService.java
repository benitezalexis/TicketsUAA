package py.com.tickets.service;

import java.util.List;


public interface GenericService<T> {
	
	List<T> getList(T obj);

	T getById(Long id);

	T insert(T obj);

	T update(T obj);

	void delete(Long id);
	
}
