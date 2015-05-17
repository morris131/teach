package cn.hnist.teach.service.inter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.hnist.teach.entity.Message;

public interface IMessageService extends IBaseService<Message, Integer> {
	
	Page<Message> findAll(Pageable pageable,Short typeId);

}
