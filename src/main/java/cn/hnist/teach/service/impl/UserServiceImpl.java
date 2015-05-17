/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.UserDao;
import cn.hnist.teach.entity.User;
import cn.hnist.teach.service.inter.IUserService;

/** 
 *	项 目 名:	teach
 *  文 件 名:	TeachUserServiceImpl.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月7日 下午6:12:51
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements IUserService {

	@Resource
	private UserDao userDao;

	@Resource(name="userDao")
	public void setRepository(
			PagingAndSortingRepository<User, Integer> repository) {
		this.repository = repository;
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
}



