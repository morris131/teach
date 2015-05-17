package cn.hnist.teach.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.OutstandStudentTypeDao;
import cn.hnist.teach.entity.OutstandStudentType;
import cn.hnist.teach.service.inter.IOutstandStudentTypeService;

@Service("outstandStudentTypeService")
@Transactional
public class OutstandStudentTypeServiceImpl extends BaseServiceImpl<OutstandStudentType, Short> implements IOutstandStudentTypeService{

	@Resource
	private OutstandStudentTypeDao outstandStudentTypeDao;
	
	@Override
	@Resource(name="outstandStudentTypeDao")
	public void setRepository(
			PagingAndSortingRepository<OutstandStudentType, Short> repository) {
		this.repository = repository;
	}

}
