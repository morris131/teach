/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.service.inter;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/** 
 *	项 目 名:	teach
 *  文 件 名:	IBaseService.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月8日 上午10:34:33
 */
public interface IBaseService<T,ID extends Serializable> {

	<S extends T> S save(S entity);

	<S extends T> List<S> save(List<S> entities);

	T findOne(ID id);

	boolean exists(ID id);

	List<T> findAll();

	List<T> findAll(List<ID> ids);

	long count();

	void delete(ID id);

	void delete(T entity);

	void delete(List<? extends T> entities);

	void deleteAll();

	List<T> findAll(Sort sort);

	Page<T> findAll(Pageable pageable);

}



