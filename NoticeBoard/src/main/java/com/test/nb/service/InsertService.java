package com.test.nb.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.test.nb.dao.nbDao;
import com.test.nb.domain.InsertInfoDto;
import com.test.nb.domain.NbInfoDto;

@Service("insertService")
public class InsertService {
	
	@Autowired
	SqlSessionTemplate template;
	
	nbDao nbIf;
	
	//게시글 작성
	
	public int insertNb(HttpServletRequest request, InsertInfoDto info) {
			int rCnt=0;
			//System.out.println(info.getU_address().length());
			if(info.getU_address().length()<1) {
				//검색어가 없을시 공백을제거해서 널값으로 만들어준다
				info.setU_address(null); 
				
			}
			// 사진 파일의 이름이 중복되는것을 막기위한 나노타임
			String nanotime =Long.toString(System.nanoTime());
			
			nbIf=template.getMapper(nbDao.class);
		
			NbInfoDto nInfo=info.toNbInfo();
			//System.out.println("insertInfo에서 NbInfo로 넘어가는 값체크>>"+nInfo.toString());
		
				// 서버경로
				String path = "/uploadfile";
				// 절대경로
				String dir = request.getSession().getServletContext().getRealPath(path);

				String newFileName = "";
				

				try {
					if (info.getU_image() != null) {
						// 새로운 파일을 생성
						newFileName = info.getU_id()+ "_"+ nanotime+ "_" +info.getU_image().getOriginalFilename();
							
						// 파일을 서버의 지정 경로에 저장
						System.out.println(dir);
						info.getU_image().transferTo(new File(dir, newFileName));

						// 데이터 베이스 저장을 하기우ㅏ한 파일 이름 set
						nInfo.setU_image(newFileName);
						System.out.println("이미지저장 이름 체크>>"+nInfo.getU_image());
						
						rCnt = nbIf.insertNb(nInfo);
					}else {
						rCnt=nbIf.insertNbNoImg(nInfo);
						
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
