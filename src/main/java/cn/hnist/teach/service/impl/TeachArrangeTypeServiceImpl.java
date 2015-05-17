package cn.hnist.teach.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.TeachArrangeTypeDao;
import cn.hnist.teach.entity.TeachArrangeType;
import cn.hnist.teach.service.inter.ITeachArrangeTypeService;

@Service("teachArrangeTypeService")
@Transactional
public class TeachArrangeTypeServiceImpl extends BaseServiceImpl<TeachArrangeType, Integer> implements ITeachArrangeTypeService{

	@Resource
	private TeachArrangeTypeDao teachArrangeTypeDao;
	
	@Override
	@Resource(name="teachArrangeTypeDao")
	public void setRepository(
			PagingAndSortingRepository<TeachArrangeType, Integer> repository) {
		this.repository = repository;
	}

}
