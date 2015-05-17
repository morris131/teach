package cn.hnist.teach.service.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hnist.teach.service.inter.IBaseService;


/** 
 *	类描述: 基本服务接口的实现类
 */
public abstract class BaseServiceImpl<T,ID extends Serializable> implements IBaseService<T,ID>{
	
	@PersistenceContext(unitName="entityManagerFactory")
	protected EntityManager entityManager;
	
	protected PagingAndSortingRepository<T, ID> repository;

	/**
	 * 
	 * 方法描述:	任何继承此类的子类都要设置repository属性
	 * 	
	 * @param repository
	 */
	public abstract void setRepository(
			PagingAndSortingRepository<T, ID> repository);

	public <S extends T> S save(S entity) {
		return repository.save(entity);
	}

	public <S extends T> Iterable<S> save(Iterable<S> entities) {
		return (Iterable<S>) repository.save(entities);
	}

	public T findOne(ID id) {
		return repository.findOne(id);
	}

	public boolean exists(ID id) {
		return repository.exists(id);
	}

	public Iterable<T> findAll() {
		return (Iterable<T>) repository.findAll();
	}

	public Iterable<T> findAll(Iterable<ID> ids) {
		return (Iterable<T>) repository.findAll(ids);
	}

	public long count() {
		return repository.count();
	}

	public void delete(ID id) {
		repository.delete(id);
	}

	public void delete(T entity) {
		repository.delete(entity);
	}

	public void delete(Iterable<? extends T> entities) {
		repository.delete(entities);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public Iterable<T> findAll(Sort sort){
		return (Iterable<T>) repository.findAll(sort);
	}

	public Page<T> findAll(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public long pageCount(int pageSize) {
		long count = this.count();
		return count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
	}
}



