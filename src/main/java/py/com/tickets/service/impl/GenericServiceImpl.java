package py.com.tickets.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import py.com.tickets.repository.GenericRepository;
import py.com.tickets.service.GenericService;

@SuppressWarnings("unchecked")
public abstract class GenericServiceImpl<T> implements GenericService<T> {

	public abstract GenericRepository<T> getRepository();

	@Override
	@Transactional
	public List<T> getList(T obj) {
		return getRepository().findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public T getById(Long id) {
		return (T) getRepository().findById(id);
	}

	@Override
	@Transactional
	public T insert(T obj) {
		return getRepository().save(obj);
	}

	@Override
	@Transactional
	public T update(T obj) {
		return getRepository().save(obj);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		getRepository().deleteById(id);
	}

}
