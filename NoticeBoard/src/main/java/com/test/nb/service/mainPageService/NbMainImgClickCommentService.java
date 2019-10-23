package com.test.nb.service.mainPageService;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.test.nb.dao.nbStartPageDao;
import com.test.nb.domain.MainImgClickCommentDto;

@Service("imgClickCommentService")
public class NbMainImgClickCommentService {
	
	@Autowired
	SqlSessionTemplate template;
	
	nbStartPageDao dao;
	
	public MainImgClickCommentDto imgClickComment(String id) {
		
		MainImgClickCommentDto mainImgClickCmDto = new MainImgClickCommentDto();
		
		Map<String, String> PhotoMap= new HashMap<String, String>(); 
		Map<String, String> guestMap= new HashMap<String, String>();
		
		dao=template.getMapper(nbStartPageDao.class);
		//가입기간 셋
		mainImgClickCmDto.setMemberdate(dao.selectMemberDate(id));
		//photoboard셋
		PhotoMap.put("category", "page");
		PhotoMap.put("nbm_id", id);
		mainImgClickCmDto.setTotalPhotoBoard(dao.selectBoardCnt(PhotoMap));
		//방명록셋
		guestMap.put("category", "scroll");
		guestMap.put("nbm_id", id);
		mainImgClickCmDto.setTotalGuestBook(dao.selectBoardCnt(guestMap));
		//총 댓글수 셋
		mainImgClickCmDto.setTotalComment(dao.selectTotalCmCnt(id));
		//업로드한 사진수 셋
		mainImgClickCmDto.setTotalUpPhoto(dao.selectTotalImage(id));
		//누적 조회수 셋
		mainImgClickCmDto.setTotalViews(dao.selectTotalViews(id));
		
		//System.out.println("체크 한번 해 봅시다>>"+mainImgClickCmDto.toString());
		return mainImgClickCmDto;
		
	}
}
