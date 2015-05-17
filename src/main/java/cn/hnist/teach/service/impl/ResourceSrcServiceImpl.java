package cn.hnist.teach.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.ResourceSrcDao;
import cn.hnist.teach.entity.ResourceSrc;
import cn.hnist.teach.service.inter.IResourceSrcService;

@Service("resourceSrcService")
@Transactional
public class ResourceSrcServiceImpl extends BaseServiceImpl<ResourceSrc, Short>
		implements IResourceSrcService {
	@Resource
	private ResourceSrcDao resourceSrcDao;

	@Override
	@Resource(name="resourceSrcDao")
	public void setRepository(
			PagingAndSortingRepository<ResourceSrc, Short> repository) {
		this.repository = repository;
	}

	

}



