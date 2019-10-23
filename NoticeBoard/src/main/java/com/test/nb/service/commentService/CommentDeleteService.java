package com.test.nb.service.commentService;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.commentDao;

@Service("cmDeleteService")
public class CommentDeleteService {

	@Autowired
	SqlSessionTemplate template;
	commentDao dao;
	//댓글의 글번호를 키워드로 댓글삭제
	public int deleteComment(int n_idx) {
		
		dao=template.getMapper(commentDao.class);
		
		
		int rCnt=0;
		
		rCnt=dao.deleteCm(n_idx);
		
		
		return rCnt;
	}
}
