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

import cn.hnist.teach.dao.DownloadResourceDao;
import cn.hnist.teach.entity.DownloadResource;
import cn.hnist.teach.service.inter.IDownloadResourceService;

@Service("downloadResourceService")
@Transactional
public class DownloadResourceServiceImpl extends BaseServiceImpl<DownloadResource, Integer> implements IDownloadResourceService{
	
	@Resource
	private DownloadResourceDao downloadResourceDao;
	
	@Override
	@Resource(name="downloadResourceDao")
	public void setRepository(
			PagingAndSortingRepository<DownloadResource, Integer> repository) {
		this.repository = repository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<DownloadResource> findAll(Pageable pageable, Short typeId) {
		String sql = "select d from DownloadResource d where d.downloadResourceType.id=:type";
		
		Query query = entityManager.createQuery(sql);
		
		query.setParameter("type", typeId);
		
		query.setFirstResult((pageable.getPageNumber())*pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());
		
		List<DownloadResource> resultList = query.getResultList();
		
		Page<DownloadResource> page = new PageImpl<DownloadResource>(resultList, pageable, downloadResourceDao.count());
		return page;
	}

	@Override
	public DownloadResource getLast(Integer id) {
		
		String sql = "select max(d.id) from DownloadResource d where d.id<:id";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("id", id);
		Integer lastId = (Integer) query.getSingleResult();
		
		if(null == lastId){
			return null;
		}
		
		return this.findOne(lastId);
	}

	@Override
	public DownloadResource getNext(Integer id) {
		
		String sql = "select min(d.id) from DownloadResource d where d.id>:id";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("id", id);
		Integer nextId = (Integer) query.getSingleResult();
		if(null == nextId){
			return null;
		}
		return this.findOne(nextId);
	}

}
