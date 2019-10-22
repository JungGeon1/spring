package com.test.nb.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbDao;

@Service("deleteService")
public class NbDeleteService {
		
		@Autowired
		SqlSessionTemplate template;
		
		nbDao nbIf;
		//삭제하고자하는 게시판의 카테고리와 글주소를 키워드로 게시판 삭제
		public int deleteBoard(String idx, String category) {
			
			nbIf=template.getMapper(nbDao.class);
			Map<String, String> deleteMap= new HashMap<String, String>();
			int rCnt=0;
			deleteMap.put("idx", idx);
			deleteMap.put("category", category);
			rCnt=nbIf.deleteNb(deleteMap);
			
			return rCnt;
			
		}
		
		
}
