package com.test.nb.service.adminBoardService;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbAdminBoardDao;
import com.test.nb.dao.nbDao;
import com.test.nb.domain.InsertInfoDto;
import com.test.nb.domain.NbAdminBoardDto;
import com.test.nb.domain.NbAdminBoardInsetInfoDto;
import com.test.nb.domain.NbInfoDto;

@Service("adminBoardinsertService")
public class NbAdminBoardInsertService {
	
	@Autowired
	SqlSessionTemplate template;
	
	nbAdminBoardDao dao;
	
	
	//게시글 작성
	
	public int insertNb(HttpServletRequest request, NbAdminBoardInsetInfoDto infoDto) {
			int rCnt=0;
		
			//  파일의 이름이 중복되는것을 막기위한 나노타임
			String nanotime =Long.toString(System.nanoTime());
			
			dao=template.getMapper(nbAdminBoardDao.class);
		
			NbAdminBoardDto boardDto=infoDto.toBoardDto();
			System.out.println("infoDto에서 NbBoardDto로 넘어가는 값체크>>"+boardDto.toString());
		
				// 서버경로
				final String path = "/uploadAdminfile";
				// 절대경로
				String dir = request.getSession().getServletContext().getRealPath(path);

				String newFileName = "";
				

				try {
					if (infoDto.getAdminBoard_file() != null) {
						// 새로운 파일을 생성
						newFileName = nanotime+ "_" +infoDto.getAdminBoard_file().getOriginalFilename();
							
						// 파일을 서버의 지정 경로에 저장
						//System.out.println(dir);
						infoDto.getAdminBoard_file().transferTo(new File(dir, newFileName));

						// 데이터 베이스 저장을 하기우ㅏ한 파일 이름 set
						boardDto.setAdminBoard_file(newFileName);
						System.out.println("파일저장 이름 체크>>"+boardDto.getAdminBoard_file());
						
						rCnt = dao.insertAdminBoard(boardDto);
					}else {
						rCnt = dao.insertAdminBoard(boardDto);
						
					}

				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		return rCnt;
	}
}
