package cn.hnist.teach.service.inter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.hnist.teach.entity.TeachNews;

public interface ITeachNewsService extends IBaseService<TeachNews, Integer> {
	
	Page<TeachNews> findAll(Pageable pageable,Short type);
	
	TeachNews getLast(Integer id);
	
	TeachNews getNext(Integer id);

}
