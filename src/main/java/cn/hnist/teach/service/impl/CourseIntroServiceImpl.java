package cn.hnist.teach.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.CourseIntroDao;
import cn.hnist.teach.entity.CourseIntro;
import cn.hnist.teach.service.inter.ICourseIntroService;

@Service("courseIntroService")
@Transactional
public class CourseIntroServiceImpl extends BaseServiceImpl<CourseIntro, Integer> implements
		ICourseIntroService {
	@Resource
	private CourseIntroDao courseIntroDao;
	
	@Resource(name="courseIntroDao")
	public void setRepository(
			PagingAndSortingRepository<CourseIntro, Integer> repository) {
		this.repository = repository;
	}

}



