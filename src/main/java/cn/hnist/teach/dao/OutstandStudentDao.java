package cn.hnist.teach.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hnist.teach.entity.OutstandStudent;

public interface OutstandStudentDao extends PagingAndSortingRepository<OutstandStudent, Integer> {

}
