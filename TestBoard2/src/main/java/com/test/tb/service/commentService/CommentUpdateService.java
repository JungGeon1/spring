package com.test.tb.service.commentService;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tb.dao.adminDao;
import com.test.tb.dao.commentDao;
import com.test.tb.domain.AdminTblDto;
import com.test.tb.domain.BoardTblDto;
import com.test.tb.domain.CommentTblDto;

@Service("commentUpdateService")
public class CommentUpdateService {
	@Autowired 
	SqlSessionTemplate template;
	
	adminDao aDao;
	
	commentDao cDao;
	
	
	public int updateComment(CommentTblDto dto) {
		
		System.out.println(dto.toString());
		aDao=template.getMapper(adminDao.class);
		cDao=template.getMapper(commentDao.class);
		int rCnt=0;
		
		AdminTblDto adminDto= new AdminTblDto();
		adminDto=aDao.adminInfo(dto.getC_id());
		//  현재 비밀번호체크 암호화X
		
		if(dto.getC_pw()!=null&&adminDto.getA_pw()!=null&&dto.getC_pw().equals(adminDto.getA_pw())) {
			//System.out.println("왔어");
			rCnt=cDao.updateComment(dto);
			System.out.println("업데이트체크>>"+rCnt);
			}else {
			rCnt=2;
			
		}
		return rCnt;
	}
}
