package cn.hnist.teach.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.ExperimentArrangeDao;
import cn.hnist.teach.entity.ExperimentArrange;
import cn.hnist.teach.service.inter.IExperimentArrangeService;

@Service("experimentArrangeService")
@Transactional
public class ExperimentArrangeServiceImpl extends BaseServiceImpl<ExperimentArrange, Integer> implements IExperimentArrangeService{

	@Resource
	private ExperimentArrangeDao experimentArrangeDao;
	
	@Override
	@Resource(name="experimentArrangeDao")
	public void setRepository(
			PagingAndSortingRepository<ExperimentArrange, Integer> repository) {
		this.repository = repository;
	}

}
