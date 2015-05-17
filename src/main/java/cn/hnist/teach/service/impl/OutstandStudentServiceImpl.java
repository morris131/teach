package cn.hnist.teach.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.OutstandStudentDao;
import cn.hnist.teach.entity.OutstandStudent;
import cn.hnist.teach.service.inter.IOutstandStudentService;

@Service("outstandStudentService")
@Transactional
public class OutstandStudentServiceImpl extends BaseServiceImpl<OutstandStudent, Integer> implements IOutstandStudentService{
	
	@Resource
	private OutstandStudentDao outstandStudentDao;
	
	@Override
	@Resource(name="outstandStudentDao")
	public void setRepository(
			PagingAndSortingRepository<OutstandStudent, Integer> repository) {
		this.repository = repository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<OutstandStudent> findAll(Pageable pageable, Short typeId) {
		String sql = "select t from OutstandStudent t where t.outstandStudentType.id=:type";
		
		Query query = entityManager.createQuery(sql);
		
		query.setParameter("type", typeId);
		
		query.setFirstResult((pageable.getPageNumber())*pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());
		
		List<OutstandStudent> resultList = query.getResultList();
		
		Page<OutstandStudent> page = new PageImpl<OutstandStudent>(resultList, pageable, outstandStudentDao.count());
		return page;
	}

	@Override
	public OutstandStudent getLast(Integer id) {
		String sql = "select max(d.id) from OutstandStudent d where d.id<:id";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("id", id);
		Integer lastId = (Integer) query.getSingleResult();
		
		if(null == lastId){
			return null;
		}
		
		return this.findOne(lastId);
	}

	@Override
	public OutstandStudent getNext(Integer id) {
		String sql = "select min(d.id) from OutstandStudent d where d.id>:id";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("id", id);
		Integer nextId = (Integer) query.getSingleResult();
		
		if(null == nextId){
			return null;
		}
		
		return this.findOne(nextId);
	}

}
