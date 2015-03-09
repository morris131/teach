/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hnist.teach.service.inter.IBaseService;


/** 
 *	项 目 名:	teach
 *  文 件 名:	BaseService.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月8日 上午10:14:07
 */
public abstract class BaseServiceImpl<T,ID extends Serializable> implements IBaseService<T,ID>{
	
	protected PagingAndSortingRepository<T, ID> repository;

	public abstract void setRepository(
			PagingAndSortingRepository<T, ID> repository);

	public <S extends T> S save(S entity) {
		return repository.save(entity);
	}

	public <S extends T> List<S> save(List<S> entities) {
		return (List<S>) repository.save(entities);
	}

	public T findOne(ID id) {
		return repository.findOne(id);
	}

	public boolean exists(ID id) {
		return repository.exists(id);
	}

	public List<T> findAll() {
		return (List<T>) repository.findAll();
	}

	public List<T> findAll(List<ID> ids) {
		return (List<T>) repository.findAll(ids);
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

	public void delete(List<? extends T> entities) {
		repository.delete(entities);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public List<T> findAll(Sort sort){
		return (List<T>) repository.findAll(sort);
	}

	public Page<T> findAll(Pageable pageable){
		return repository.findAll(pageable);
	}
}



