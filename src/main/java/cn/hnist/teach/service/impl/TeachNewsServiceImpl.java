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

import cn.hnist.teach.dao.TeachNewsDao;
import cn.hnist.teach.entity.TeachNews;
import cn.hnist.teach.service.inter.ITeachNewsService;

@Service("teachNewsService")
@Transactional
public class TeachNewsServiceImpl extends BaseServiceImpl<TeachNews, Integer> implements ITeachNewsService{
	
	@PersistenceContext(unitName="entityManagerFactory")
	private EntityManager entityManager;
	
	@Resource
	private TeachNewsDao teachNewsDao;

	@Override
	@Resource(name="teachNewsDao")
	public void setRepository(
			PagingAndSortingRepository<TeachNews, Integer> repository) {
		this.repository = repository;
	}
	
	@Override
	public Page<TeachNews> findAll(Pageable pageable){
		String sql = "select t from TeachNews t order by t.datetime desc";
		
		Query query = entityManager.createQuery(sql);
		
		query.setFirstResult((pageable.getPageNumber())*pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());
		
		@SuppressWarnings("unchecked")
		List<TeachNews> resultList = query.getResultList();
		
		Page<TeachNews> page = new PageImpl<TeachNews>(resultList, pageable, teachNewsDao.count());
		
		return page;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<TeachNews> findAll(Pageable pageable, Short type) {
		
		String sql = "select t from TeachNews t where t.type=:type order by t.datetime desc";
		
		Query query = entityManager.createQuery(sql);
		
		query.setParameter("type", type);
		
		query.setFirstResult((pageable.getPageNumber())*pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());
		
		List<TeachNews> resultList = query.getResultList();
		
		Page<TeachNews> page = new PageImpl<TeachNews>(resultList, pageable, teachNewsDao.count());
		
		return page;
	}

	@Override
	public TeachNews getLast(Integer id) {
		
		String sql = "select max(d.id) from TeachNews d where d.id<:id";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("id", id);
		Integer lastId = (Integer) query.getSingleResult();
		
		if(null == lastId){
			return null;
		}
		
		return this.findOne(lastId);
	}

	@Override
	public TeachNews getNext(Integer id) {
		
		String sql = "select min(d.id) from TeachNews d where d.id>:id";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("id", id);
		Integer nextId = (Integer) query.getSingleResult();
		if(null == nextId){
			return null;
		}
		return this.findOne(nextId);
	}


}
