package cn.hnist.teach.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.TeachArrangeDao;
import cn.hnist.teach.entity.TeachArrange;
import cn.hnist.teach.service.inter.ITeachArrangeService;

@Service("teachArrangeService")
@Transactional
public class TeachArrangeServiceImpl extends BaseServiceImpl<TeachArrange, Integer> implements ITeachArrangeService{

	@PersistenceContext(unitName="entityManagerFactory")
	private EntityManager entityManager;
	
	@Resource
	private TeachArrangeDao teachArrangeDao;
	
	@Override
	@Resource(name="teachArrangeDao")
	public void setRepository(
			PagingAndSortingRepository<TeachArrange, Integer> repository) {
		this.repository = repository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<TeachArrange> findAll(Pageable pageable, Integer typeId) {
		String sql = "select t from TeachArrange t where t.teachArrangeType.id=:type";
		
		Query query = entityManager.createQuery(sql);
		
		query.setParameter("type", typeId);
		
		query.setFirstResult((pageable.getPageNumber())*pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());
		
		List<TeachArrange> resultList = query.getResultList();
		
		Page<TeachArrange> page = new PageImpl<TeachArrange>(resultList, pageable, teachArrangeDao.count());
		return page;
	}
	
	@Override
	public TeachArrange getLast(Integer id) {
		
		String sql = "select max(d.id) from TeachArrange d where d.id<:id";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("id", id);
		Integer lastId = (Integer) query.getSingleResult();
		
		if(null == lastId){
			return null;
		}
		
		return this.findOne(lastId);
	}

	@Override
	public TeachArrange getNext(Integer id) {
		
		String sql = "select min(d.id) from TeachArrange d where d.id>:id";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("id", id);
		Integer nextId = (Integer) query.getSingleResult();
		if(null == nextId){
			return null;
		}
		return this.findOne(nextId);
	}



}
