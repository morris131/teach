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

import cn.hnist.teach.dao.MessageDao;
import cn.hnist.teach.entity.Message;
import cn.hnist.teach.service.inter.IMessageService;

@Service("messageService")
@Transactional
public class MessageServiceImpl extends BaseServiceImpl<Message, Integer> implements IMessageService{

	@Resource
	private MessageDao messageDao;
	
	@PersistenceContext(unitName="entityManagerFactory")
	private EntityManager entityManager;
	
	@Override
	@Resource(name="messageDao")
	public void setRepository(
			PagingAndSortingRepository<Message, Integer> repository) {
		this.repository = repository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<Message> findAll(final Pageable pageable, final Short typeId) {

		String sql = "select m from Message m where m.isValid=:type";

		Query query = entityManager.createQuery(sql);

		query.setParameter("type", typeId);

		query.setFirstResult((pageable.getPageNumber())
				* pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());

		List<Message> resultList = query.getResultList();

		Page<Message> page = new PageImpl<Message>(resultList,
				pageable, messageDao.count());
		return page;

	}

}
