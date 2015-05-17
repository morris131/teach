package cn.hnist.teach.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hnist.teach.entity.LoginLog;

public interface LoginLogDao extends
		PagingAndSortingRepository<LoginLog, Integer> {

}



