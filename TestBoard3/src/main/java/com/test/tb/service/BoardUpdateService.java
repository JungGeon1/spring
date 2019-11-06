package com.test.tb.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tb.dao.adminDao;
import com.test.tb.dao.boardDao;
import com.test.tb.domain.AdminTblDto;
import com.test.tb.domain.BoardTblDto;

@Service("boardUpdateService")
public class BoardUpdateService {
	@Autowired 
	SqlSessionTemplate template;
	
	adminDao aDao;
	
	boardDao bDao;
	
	
	public int updateBoard(BoardTblDto dto) {
		aDao=template.getMapper(adminDao.class);
		bDao=template.getMapper(boardDao.class);
		int rCnt=0;
		
		AdminTblDto adminDto= new AdminTblDto();
		adminDto=aDao.adminInfo(dto.getB2_id());
		//  현재 비밀번호체크 암호화X
		
		if(dto.getB2_pw()!=null&&adminDto.getA2_pw()!=null&&dto.getB2_pw().equals(adminDto.getA2_pw())) {
			System.out.println("왔어");
			rCnt=bDao.updateBoard(dto);
			System.out.println("업데이트체크>>"+rCnt);
			}else {
			rCnt=2;
			
		}
		return rCnt;
	}
}
