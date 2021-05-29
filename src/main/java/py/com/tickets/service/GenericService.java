package py.com.tickets.service;

import java.util.List;

import javax.transaction.Transactional;


public interface GenericService<T> {
	
	List<T> getList(T obj);

	T getById(Long id);

	T insert(T obj);

	T update(T obj);

	void delete(Long id);
	
	@Transactional
	void deleteObj(T obj);
}
