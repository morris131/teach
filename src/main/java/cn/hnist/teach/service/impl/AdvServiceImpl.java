package cn.hnist.teach.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.AdvDao;
import cn.hnist.teach.entity.Adv;
import cn.hnist.teach.service.inter.IAdvService;

@Service("advService")
@Transactional
public class AdvServiceImpl extends BaseServiceImpl<Adv, Integer> implements IAdvService{

	@Resource
	private AdvDao advDao;
	
	@Override
	@Resource(name="advDao")
	public void setRepository(
			PagingAndSortingRepository<Adv, Integer> repository) {
		this.repository = repository;
	}

}



