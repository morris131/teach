/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.RoleDao;
import cn.hnist.teach.entity.Role;
import cn.hnist.teach.service.inter.IRoleService;

/** 
 *	项 目 名:	teach
 *  文 件 名:	RoleServiceImpl.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月12日 下午11:13:18
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role, Integer> implements IRoleService{

	@Resource
	private RoleDao roleDao;
	
	@Resource(name="roleDao")
	public void setRepository(
			PagingAndSortingRepository<Role, Integer> repository) {
		this.repository = repository;
	}

}



