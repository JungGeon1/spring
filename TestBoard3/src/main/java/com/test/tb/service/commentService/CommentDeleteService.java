package com.test.tb.service.commentService;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tb.dao.adminDao;
import com.test.tb.dao.commentDao;
import com.test.tb.domain.AdminTblDto;
import com.test.tb.domain.BoardTblDto;
import com.test.tb.domain.CommentTblDto;

@Service("commentDeleteService")
public class CommentDeleteService {
	@Autowired 
	SqlSessionTemplate template;
	
	adminDao aDao;
	
	commentDao cDao;
	
	
	public int deleteComment(CommentTblDto dto) {
		System.out.println(dto.toString());
		aDao=template.getMapper(adminDao.class);
		cDao=template.getMapper(commentDao.class);
		int rCnt=0;
		
		AdminTblDto adminDto= new AdminTblDto();
		adminDto=aDao.adminInfo(dto.getC_id());
		//  현재 비밀번호체크 암호화X
		
		if(dto.getC_pw()!=null&&adminDto.getA2_pw()!=null&&dto.getC_pw().equals(adminDto.getA2_pw())) {
	
			rCnt=cDao.deleteComment(dto.getC_idx());
		
			}else {
			rCnt=2;
			
		}
		return rCnt;
	}
}
