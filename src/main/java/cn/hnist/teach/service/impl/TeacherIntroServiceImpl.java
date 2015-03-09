/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.TeacherIntroDao;
import cn.hnist.teach.entity.TeacherIntro;
import cn.hnist.teach.service.inter.ITeacherIntroService;

/** 
 *	项 目 名:	teach
 *  文 件 名:	TeacherIntroServiceImpl.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月9日 下午8:38:03
 */
@Service("teacherIntroService")
@Transactional
public class TeacherIntroServiceImpl extends BaseServiceImpl<TeacherIntro, Integer> implements ITeacherIntroService<TeacherIntro, Integer>{

	@Resource
	private TeacherIntroDao teacherIntroDao;
	
	@Resource(name="teacherIntroDao")
	public void setRepository(
			PagingAndSortingRepository<TeacherIntro, Integer> repository) {
		this.repository = repository;
	}

}



