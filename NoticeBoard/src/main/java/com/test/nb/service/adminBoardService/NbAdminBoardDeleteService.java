package com.test.nb.service.adminBoardService;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbAdminBoardDao;
import com.test.nb.domain.NbAdminBoardDto;

@Service("adminBoardDeleteService")
public class NbAdminBoardDeleteService {
	@Autowired
	SqlSessionTemplate template;

	nbAdminBoardDao dao;

	public int adminDeleteBoard(int idx, HttpServletRequest request) {
		dao = template.getMapper(nbAdminBoardDao.class);

		int rCnt = 0;
		
		
		NbAdminBoardDto boardDto= new NbAdminBoardDto();
		//삭제보다 밑에 작성할 경우 기존 idx값은 이미 db에서 사라지므로 정보를 가져오지못한다 개고생했다 잊지말자
		boardDto = dao.adminBoardInfo(idx);
		
		rCnt = dao.adminDeleteBoard(idx);
		// DB정보가 삭제될시 서버에 올라간 파일삭제
		if (rCnt == 1) {
			String fileName = "";
			// 서버경로
			final String path = "/uploadAdminfile";
			// 절대경로
			String saveDirectory = request.getSession().getServletContext().getRealPath(path);
			//System.out.println("파일저장경로>>" + saveDirectory);
			
			
			//System.out.println(boardDto.getAdminBoard_id());
			if (boardDto != null) {
				//System.out.println("널값은아니야");
				fileName = boardDto.getAdminBoard_file();

				File file = new File(saveDirectory + '\\' + fileName);
				// exists->경로에 파일이 존재하는지 확인한다
				if (file.exists()) {
					if (file.delete()) {
						System.out.println("파일삭제 성공");
					} else {
						System.out.println("파일삭제 실패");
					}
				} else {
					System.out.println("파일이 존재하지 않습니다.");
				}

			}
		}
		return rCnt;

	}
}
