package cn.hnist.teach.service.inter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.hnist.teach.entity.DownloadResource;

public interface IDownloadResourceService extends IBaseService<DownloadResource, Integer> {
	
	/**
	 * 
	 * 方法描述: 根据实体类型和分页参数获得一页实体
	 * 	
	 * @param pageable 分页对象
	 * @param typeId 实体类型
	 * @return
	 */
	Page<DownloadResource> findAll(Pageable pageable,Short typeId);
	
	/**
	 * 
	 * 方法描述:	根据主键id获得上一个实体
	 * 	
	 * @param id 实体的主键
	 * @return
	 */
	DownloadResource getLast(Integer id);
	
	/**
	 * 
	 * 方法描述:	根据主键id获得下一个实体
	 * 	
	 * @param id 实体的主键
	 * @return
	 */
	DownloadResource getNext(Integer id);
	
	
	

}
