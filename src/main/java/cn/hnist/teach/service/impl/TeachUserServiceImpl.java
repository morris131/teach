/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.TeachUserDao;
import cn.hnist.teach.entity.TeachUser;
import cn.hnist.teach.service.inter.ITeachUserService;

/** 
 *	项 目 名:	teach
 *  文 件 名:	TeachUserServiceImpl.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月7日 下午6:12:51
 */
@Service("teachUserService")
@Transactional
public class TeachUserServiceImpl extends BaseServiceImpl<TeachUser, String> implements ITeachUserService<TeachUser, String> {

	@Resource
	private TeachUserDao teachUserDao;

	@Resource(name="teachUserDao")
	public void setRepository(
			PagingAndSortingRepository<TeachUser, String> repository) {
		this.repository = repository;
	}
	
	

	

}



