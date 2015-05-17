package cn.hnist.teach.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.LoginLogDao;
import cn.hnist.teach.entity.LoginLog;
import cn.hnist.teach.service.inter.ILoginLogService;

@Service("loginLogService")
@Transactional
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLog, Integer> implements ILoginLogService {
	
	@Resource
	private LoginLogDao loginLogDao;

	@Override
	@Resource(name="loginLogDao")
	public void setRepository(
			PagingAndSortingRepository<LoginLog, Integer> repository) {
		this.repository = repository;
	}

}



