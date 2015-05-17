package cn.hnist.teach.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hnist.teach.entity.TeachNews;

public interface TeachNewsDao extends PagingAndSortingRepository<TeachNews, Integer> {

}
