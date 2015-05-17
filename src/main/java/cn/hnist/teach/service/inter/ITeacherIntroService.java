/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.service.inter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.hnist.teach.entity.TeacherIntro;

/** 
 *	项 目 名:	teach
 *  文 件 名:	ITeacherIntroService.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月9日 下午8:36:04
 */
public interface ITeacherIntroService extends IBaseService<TeacherIntro, Integer>{
	
	Page<TeacherIntro> findAll(Pageable pageable,Integer type);
	
	TeacherIntro getLast(Integer id);
	
	TeacherIntro getNext(Integer id);

}



