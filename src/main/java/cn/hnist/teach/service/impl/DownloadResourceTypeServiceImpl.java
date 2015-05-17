package cn.hnist.teach.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import cn.hnist.teach.dao.DownloadResourceTypeDao;
import cn.hnist.teach.entity.DownloadResourceType;
import cn.hnist.teach.service.inter.IDownloadResourceTypeService;

@Service("downloadResourceTypeService")
@Transactional
public class DownloadResourceTypeServiceImpl extends BaseServiceImpl<DownloadResourceType, Short> implements IDownloadResourceTypeService{

	@Resource
	private DownloadResourceTypeDao downloadResourceTypeDao;
	
	@Override
	@Resource(name="downloadResourceTypeDao")
	public void setRepository(
			PagingAndSortingRepository<DownloadResourceType, Short> repository) {
		this.repository = repository;
	}

}
