package cn.hnist.teach.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hnist.teach.entity.DownloadResource;

public interface DownloadResourceDao extends PagingAndSortingRepository<DownloadResource, Integer> {

}
