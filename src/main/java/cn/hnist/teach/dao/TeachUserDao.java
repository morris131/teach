/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hnist.teach.entity.TeachUser;

/** 
 *	项 目 名:	teach
 *  文 件 名:	TeachUserDao.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月7日 下午6:04:53
 */
public interface TeachUserDao extends PagingAndSortingRepository<TeachUser, String>{

}



