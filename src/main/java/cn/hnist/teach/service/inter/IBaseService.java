package cn.hnist.teach.service.inter;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/** 
 *	接口描述: 基本服务接口
 */
public interface IBaseService<T,ID extends Serializable> {

	/**
	 * 
	 * 方法描述:	保存一个实体
	 * 	
	 * @param entity 要保存的实体
	 * @return
	 */
	<S extends T> S save(S entity);

	/**
	 * 
	 * 方法描述:	批量保存实体
	 * 	
	 * @param entities 要保存的多个实体
	 * @return
	 */
	<S extends T> Iterable<S> save(Iterable<S> entities);
	
	/**
	 * 
	 * 方法描述:	通过主键id找到对应的实体
	 * 	
	 * @param id 实体的主键
	 * @return
	 */
	T findOne(ID id);

	/**
	 * 
	 * 方法描述:	根据主键id判断对应的实体是否存在
	 * 	
	 * @param id 实体的主键
	 * @return
	 */
	boolean exists(ID id);

	/**
	 * 
	 * 方法描述:	获得所有的实体
	 * 	
	 * @return
	 */
	Iterable<T> findAll();
	
	/**
	 * 
	 * 方法描述:	通过多个主键id获得多个实体
	 * 	
	 * @param ids 多个实体的主键
	 * @return
	 */
	Iterable<T> findAll(Iterable<ID> ids);

	/**
	 * 
	 * 方法描述:	获得所有实体的个数
	 * 	
	 * @return
	 */
	long count();

	/**
	 * 
	 * 方法描述:	根据主键id删除对应的实体
	 * 	
	 * @param id 实体的主键
	 */
	void delete(ID id);

	/**
	 * 
	 * 方法描述: 根据实体删除对应的实体
	 * 	
	 * @param entity 实体
	 */
	void delete(T entity);

	/**
	 * 
	 * 方法描述:	批量删除实体
	 * 	
	 * @param entities 要删除的多个实体
	 */
	void delete(Iterable<? extends T> entities);

	/**
	 * 
	 * 方法描述:	删除所有的实体
	 *
	 */
	void deleteAll();
	
	/**
	 * 
	 * 方法描述:	根据排序参数获得排序后的所有实体
	 * 	
	 * @param sort 排序对象
	 * @return
	 */
	Iterable<T> findAll(Sort sort);
	
	/**
	 * 
	 * 方法描述:	根据分页参数获得一页实体
	 * 	
	 * @param pageable 分页对象
	 * @return
	 */
	Page<T> findAll(Pageable pageable);
	
	/**
	 * 
	 * 方法描述:	根据每页的大小获得总页数
	 * 	
	 * @param pageSize
	 * @return
	 */
	long pageCount(int pageSize);
}



