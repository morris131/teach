/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hnist.teach.entity.Role;

/** 
 *	项 目 名:	teach
 *  文 件 名:	RoleDao.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月12日 下午11:11:51
 */
public interface RoleDao extends PagingAndSortingRepository<Role, Integer> {

}



