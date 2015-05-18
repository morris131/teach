package cn.hnist.teach.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hnist.teach.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Integer>{

	User findByUsername(String username);
}



