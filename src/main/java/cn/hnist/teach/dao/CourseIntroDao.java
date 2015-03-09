/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hnist.teach.entity.CourseIntro;

/** 
 *	项 目 名:	teach
 *  文 件 名:	CourseIntroDao.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月8日 上午10:11:21
 */
public interface CourseIntroDao extends PagingAndSortingRepository<CourseIntro, Integer>{
	
}



