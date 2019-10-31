package com.test.tb.service.commentService;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tb.dao.boardDao;
import com.test.tb.dao.commentDao;
import com.test.tb.domain.BoardTblDto;
import com.test.tb.domain.CommentTblDto;

@Service(value = "commentListService")
public class CommentListService {
	@Autowired 
	SqlSessionTemplate template;
	
	commentDao dao;
	//리스트
	public List<CommentTblDto> getList(int idx){
		
		dao=template.getMapper(commentDao.class);
		List<CommentTblDto> list = new ArrayList<CommentTblDto>();

		list=dao.selectList(idx);
		for(CommentTblDto dto  : list ) {
			if(dto.getC_depth()>1) {
				StringBuffer sb= new StringBuffer();
				String sp= "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				for(int i=2;i<=dto.getC_depth();i++){
					sb.append(sp);
				}
				sb.append("ㄴ[답글]");
				sb.append(dto.getC_comment());
				dto.setC_comment(sb.toString());
			}
			
		}
		
		return list;
	}
	
	
	
	//총갯수
	public int allCommentcnt() {
		dao=template.getMapper(commentDao.class);
		int rCnt=0;
		rCnt= dao.allCommentdCnt();
		return rCnt;
	}
	
	
	public CommentTblDto commentInfo(int idx) {
		dao=template.getMapper(commentDao.class);
		
		CommentTblDto dto = new CommentTblDto();
		
		dto=dao.commentInfo(idx);
		
		return dto;
		
	}

}
