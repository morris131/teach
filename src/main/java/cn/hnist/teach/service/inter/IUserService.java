/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.service.inter;

import cn.hnist.teach.entity.User;

/** 
 *	项 目 名:	teach
 *  文 件 名:	ITeachUserService.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月7日 下午6:10:57
 */
public interface IUserService extends IBaseService<User, Integer>{
	
	User findByUsername(String username);
	
}



