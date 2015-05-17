/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
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

import cn.hnist.teach.dao.TeacherIntroDao;
import cn.hnist.teach.entity.TeacherIntro;
import cn.hnist.teach.service.inter.ITeacherIntroService;

/** 
 *	项 目 名:	teach
 *  文 件 名:	TeacherIntroServiceImpl.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月9日 下午8:38:03
 */
@Service("teacherIntroService")
@Transactional
public class TeacherIntroServiceImpl extends BaseServiceImpl<TeacherIntro, Integer> implements ITeacherIntroService{

	@PersistenceContext(unitName="entityManagerFactory")
	private EntityManager entityManager;
	
	@Resource
	private TeacherIntroDao teacherIntroDao;
	
	@Resource(name="teacherIntroDao")
	public void setRepository(
			PagingAndSortingRepository<TeacherIntro, Integer> repository) {
		this.repository = repository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<TeacherIntro> findAll(Pageable pageable, Integer type) {

		String sql = "select t from TeacherIntro t where t.teacherIntroType.id=:type";

		Query query = entityManager.createQuery(sql);

		query.setParameter("type", type);

		query.setFirstResult((pageable.getPageNumber())
				* pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());

		List<TeacherIntro> resultList = query.getResultList();

		Page<TeacherIntro> page = new PageImpl<TeacherIntro>(resultList,pageable, teacherIntroDao.count());

		return page;
	}
	
	@Override
	public TeacherIntro getLast(Integer id) {
		
		String sql = "select max(d.id) from TeacherIntro d where d.id<:id";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("id", id);
		Integer lastId = (Integer) query.getSingleResult();
		
		if(null == lastId){
			return null;
		}
		
		return this.findOne(lastId);
	}

	@Override
	public TeacherIntro getNext(Integer id) {
		
		String sql = "select min(d.id) from TeacherIntro d where d.id>:id";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter("id", id);
		Integer nextId = (Integer) query.getSingleResult();
		if(null == nextId){
			return null;
		}
		return this.findOne(nextId);
	}


}



