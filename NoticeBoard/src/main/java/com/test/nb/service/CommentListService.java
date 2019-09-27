package com.test.nb.service;

import java.util.ArrayList;
import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.commentDao;
import com.test.nb.domain.CommentDto;


@Service("cListService")
public class CommentListService {
	@Autowired
	SqlSessionTemplate template;
	
	commentDao dao;
	
	
	public List<CommentDto> getCLiset(int idx) {
		
		
		dao=template.getMapper(commentDao.class);
		
		List<CommentDto> list= new ArrayList<CommentDto>();
		
		list=dao.commentList(idx);
	
		return list;
	}
	
}
