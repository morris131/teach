package cn.hnist.teach.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hnist.teach.entity.Message;

public interface MessageDao extends PagingAndSortingRepository<Message, Integer>{

}
