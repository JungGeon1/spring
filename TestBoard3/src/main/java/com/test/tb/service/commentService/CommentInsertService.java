package com.test.tb.service.commentService;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tb.dao.boardDao;
import com.test.tb.dao.commentDao;
import com.test.tb.domain.BoardTblDto;
import com.test.tb.domain.CommentTblDto;

@Service(value = "commentInsertService")
public class CommentInsertService {
	@Autowired
	SqlSessionTemplate template;
	
	commentDao dao;
	
	public int commentInsert(CommentTblDto dto) {
		
		dao=template.getMapper(commentDao.class);
		
		int rCnt=0;
		
		rCnt=dao.commentInsert(dto);
		
		return rCnt;
	}
	
	
	
	public int reCommentInsert(CommentTblDto dto) {
		
		dao=template.getMapper(commentDao.class);

		int rCnt=0;
		//1번쿼리체크
		int chkOrd=0;
		
		int maxOrd=0;
		//원글 정보 바인딩
		CommentTblDto orgCommentDto = new CommentTblDto();
		
		orgCommentDto=dao. commentInfo(dto.getO_no());
		
		//System.out.println("원글 정보확인>>"+orgBoardDto.toString());
		
		chkOrd= dao.selectGrpord(orgCommentDto);
		//답글이 맨 밑으로 가는경우
		if(chkOrd==0) {
			maxOrd=dao.selectMaxOrd(orgCommentDto.getC_grpno());
			System.out.println("쿼리가 0일떄");
			dto.setC_grpno(orgCommentDto.getC_grpno());
			dto.setC_grpord(maxOrd);
			dto.setC_depth(orgCommentDto.getC_depth());
			rCnt=dao.reInsert(dto);
		}
		//답글이 중간에 들어가는 경우
		else {
			System.out.println("쿼리가 1일떄");
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			map.put("c_grpno",orgCommentDto.getC_grpno());
			map.put("selectGrpOrd", chkOrd);
			dao.upGrpOrd(map);
			
			dto.setC_grpno(orgCommentDto.getC_grpno());
			dto.setC_grpord(chkOrd);
			dto.setC_depth(orgCommentDto.getC_depth());
			rCnt=dao.reInsert(dto);
			
		}
		
		return rCnt;
	}
	
}
