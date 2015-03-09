/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.TeacherIntroTypeDao;
import cn.hnist.teach.entity.TeacherIntroType;
import cn.hnist.teach.service.inter.ITeacherIntroTypeService;

/** 
 *	项 目 名:	teach
 *  文 件 名:	TeacherIntroTypeServiceImpl.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月9日 下午9:08:19
 */
@Service("teacherIntroTypeService")
@Transactional
public class TeacherIntroTypeServiceImpl extends BaseServiceImpl<TeacherIntroType, Integer>
		implements ITeacherIntroTypeService<TeacherIntroType, Integer> {

	@Resource
	private TeacherIntroTypeDao teacherIntroTypeDao;
	
	@Resource(name="teacherIntroTypeDao")
	public void setRepository(
			PagingAndSortingRepository<TeacherIntroType, Integer> repository) {
		this.repository = repository;
	}

}



