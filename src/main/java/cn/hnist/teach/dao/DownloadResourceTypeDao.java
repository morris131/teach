package cn.hnist.teach.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hnist.teach.entity.DownloadResourceType;

public interface DownloadResourceTypeDao extends
		PagingAndSortingRepository<DownloadResourceType, Integer> {

}
