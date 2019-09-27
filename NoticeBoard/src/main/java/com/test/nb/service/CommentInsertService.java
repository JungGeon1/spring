package com.test.nb.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.commentDao;
import com.test.nb.domain.CommentDto;

@Service("commentInsert")
public class CommentInsertService {
	@Autowired
	SqlSessionTemplate template;
	
	commentDao dao;
	
	public int insertComment(CommentDto cDto) {
		int rCnt=0;
		int comentCnt=0;
		dao=template.getMapper(commentDao.class);
		comentCnt=commentCount(cDto);
		//전체 게시물 수를 뽑아와 하나 증가시켜 넣어준다 
		cDto.setN_grpno(comentCnt+1);
		rCnt=dao.insertCm(cDto);
		return rCnt;
		
	}
	public int insertReComment(CommentDto cDto) {
		int uChk=0;
		int rCnt=0;
		int depthchk=0;
		
		StringBuffer sbr= new StringBuffer();
		dao=template.getMapper(commentDao.class);
		
		uChk=dao.ReCmUp(cDto);
		System.out.println("uChk체크>>"+uChk);
		cDto.setN_grpord(cDto.getN_grpord()+1);
		cDto.setN_depth(cDto.getN_depth()+1);
		
		depthchk=cDto.getN_depth();
		
		for(int i=0; i<depthchk-1;i++) {
		sbr.append("RE");
		}
		sbr.append(":");
		sbr.append(cDto.getN_comment());
//		
		cDto.setN_comment(sbr.toString());
		rCnt=dao.insertReCm(cDto);
		return rCnt;
		
	}
	
	public int commentCount(CommentDto cDto) {
		int rCnt=0;
		
		dao=template.getMapper(commentDao.class);
		
		
		rCnt=dao.selectCommentCnt(cDto.getU_idx());
		return rCnt;
		
	}
	//리스트 출력시 댓글 갯수 구하기용 
	public int commentCount(int idx) {
		int rCnt=0;
		
		dao=template.getMapper(commentDao.class);
		
		
		rCnt=dao.selectCommentCnt(idx);
		return rCnt;
		
	}

}
