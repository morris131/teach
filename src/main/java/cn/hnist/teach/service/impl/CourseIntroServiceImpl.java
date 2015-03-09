/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.CourseIntroDao;
import cn.hnist.teach.entity.CourseIntro;
import cn.hnist.teach.service.inter.ICourseIntroService;

/** 
 *	项 目 名:	teach
 *  文 件 名:	CourseIntroServiceImpl.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月8日 上午10:50:20
 */
@Service("courseIntroService")
@Transactional
public class CourseIntroServiceImpl extends BaseServiceImpl<CourseIntro, Integer> implements
		ICourseIntroService<CourseIntro, Integer> {
	@Resource
	private CourseIntroDao courseIntroDao;
	
	@Resource(name="courseIntroDao")
	public void setRepository(
			PagingAndSortingRepository<CourseIntro, Integer> repository) {
		this.repository = repository;
	}

}



