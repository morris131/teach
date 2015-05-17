package cn.hnist.teach.service.inter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.hnist.teach.entity.TeachArrange;

public interface ITeachArrangeService extends IBaseService<TeachArrange, Integer>{
	
	Page<TeachArrange> findAll(Pageable pageable,Integer typeId);
	
	TeachArrange getLast(Integer id);
	
	TeachArrange getNext(Integer id);


}
