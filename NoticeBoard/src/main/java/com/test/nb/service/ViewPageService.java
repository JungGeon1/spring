package com.test.nb.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbDao;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.ViewPageDataDto;

@Service("viewPageService")
public class ViewPageService {
	
	@Autowired
	SqlSessionTemplate template;
	
	nbDao nbIf;
	
	public NbInfoDto viewData(ViewPageDataDto pageData) {
		
		nbIf= template.getMapper(nbDao.class);
		
		NbInfoDto nbInfo= new NbInfoDto();
		//System.out.println(pageData.toString());	
		nbInfo=nbIf.selectViewPage(pageData);
		//System.out.println("ViewPageData체크>>>"+nbInfo.toString());
		return nbInfo;
	}
}
