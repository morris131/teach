package cn.hnist.teach.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hnist.teach.entity.OutstandStudentType;

public interface OutstandStudentTypeDao extends
		PagingAndSortingRepository<OutstandStudentType, Short> {

}
