package cn.hnist.teach.service.inter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.hnist.teach.entity.OutstandStudent;

public interface IOutstandStudentService extends IBaseService<OutstandStudent, Integer> {

	Page<OutstandStudent> findAll(Pageable pageable,Short typeId);
	
	/**
	 * 
	 * 方法描述:	根据主键id获得上一个实体
	 * 	
	 * @param id 实体的主键
	 * @return
	 */
	OutstandStudent getLast(Integer id);
	
	/**
	 * 
	 * 方法描述:	根据主键id获得下一个实体
	 * 	
	 * @param id 实体的主键
	 * @return
	 */
	OutstandStudent getNext(Integer id);
}
