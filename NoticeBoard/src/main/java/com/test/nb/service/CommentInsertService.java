package com.test.nb.service;

import java.util.HashMap;
import java.util.Map;

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
	//댓글입력
	public int insertComment(CommentDto cDto) {
		int rCnt=0;
		int comentCnt=0;
		dao=template.getMapper(commentDao.class);
		comentCnt=commentCount(cDto);
		//전체 게시물 수를 뽑아와 grpno를 하나 증가시켜 넣어준다 
		cDto.setN_grpno(comentCnt+1);
		rCnt=dao.insertCm(cDto);
		return rCnt;
		
	}
	
	//내림차순답글입력
	public int insertReComment(CommentDto cDto) {
		int uChk=0;
		int rCnt=0;
		int depthchk=0;
		
		StringBuffer sbr= new StringBuffer();
		dao=template.getMapper(commentDao.class);
		
		uChk=dao.ReCmUp(cDto);
		//System.out.println("uChk체크>>"+uChk);
		cDto.setN_grpord(cDto.getN_grpord()+1);
		cDto.setN_depth(cDto.getN_depth()+1);
		
		depthchk=cDto.getN_depth();
		
	//답글의 dept체크
		for(int i=0; i<depthchk-1;i++) {
		sbr.append("RE");
		}
		sbr.append(":");
		sbr.append(cDto.getN_comment());
		
		cDto.setN_comment(sbr.toString());
		rCnt=dao.insertReCm(cDto);
		return rCnt;
		
	}
	//오름차순 답글
	public int insertAscReComment(CommentDto cDto) {
		dao=template.getMapper(commentDao.class);
		
		
		//입력받은 답글의n_grpord가 0일지 아닐지 체크
		int chkGord=0;
		//chkGrpord가 0일경우의 grpord의값
		int selectGord=0;
		//chkGrpord가 0이 아닐경우의 grpord의값
		int upGord = 0;
		
		int rCnt=0;
		  
		chkGord =dao.chkGrpord(cDto);
		System.out.println("chkGord의 값>>"+chkGord);
		
		if(chkGord==0) {
			int n_grpno=0;
			n_grpno=cDto.getN_grpno();
			selectGord=dao.selectGrpord(n_grpno);
			System.out.println("selectGord의 값>>"+selectGord);
			cDto.setN_grpord(selectGord);
			
			rCnt=dao.insertAscReCm(cDto);
			
		}else {
			int n_grpno=0;
			Map<String, Integer> map= new HashMap<String,Integer>();
			
			n_grpno=cDto.getN_grpno();
			
			
			map.put("n_grpno", n_grpno);
			
			map.put("chkGrpord", chkGord);
			
			
			upGord= dao.upGrpord(map);
			System.out.println("upGord체크>>"+upGord);
			
			rCnt=dao.insertAscReCm(cDto);
			
			
			
		}
		
		
	
		return rCnt;
		
	}
	
	
	
	
	//댓글입력시 grpno증가를 위해 전체 개시글의 갯수를 가져온다
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
