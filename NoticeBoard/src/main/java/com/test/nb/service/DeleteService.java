package com.test.nb.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbDao;

@Service("deleteService")
public class DeleteService {
		
		@Autowired
		SqlSessionTemplate template;
		
		nbDao nbIf;
		
		public int deleteBoard(Map<String, String> deleteMap) {
			
			nbIf=template.getMapper(nbDao.class);
			
			int rCnt=0;
			
			rCnt=nbIf.deleteNb(deleteMap);
			
			return rCnt;
			
		}
		
}
