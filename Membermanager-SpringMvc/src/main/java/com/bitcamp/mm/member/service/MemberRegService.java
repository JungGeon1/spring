package com.bitcamp.mm.member.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberJdbcTempleteDao;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.RequestMemberRegist;

@Service("regsitService")
public class MemberRegService implements MemberService {

	@Autowired
	private MemberJdbcTempleteDao templeteDao;

	public int memberInsert(HttpServletRequest request, RequestMemberRegist regist) {
		// 서버경로
		String path = "/uploadfile/userphoto";
		// 절대경로
		String dir = request.getSession().getServletContext().getRealPath(path);

		MemberInfo memberInfo = regist.toMemInfo();

		// 새로운 파일을 생성
		String newFileName = memberInfo.getuId() + "_" + regist.getuPhoto().getOriginalFilename();

		int resultCnt = 0;

		try {

			// 파일을 서버의 지정 경로에 저장
			System.out.println(dir);
			regist.getuPhoto().transferTo(new File(dir, newFileName));

			// 데이터 베이스 저장을 하기우ㅏ한 파일 이름 set
			memberInfo.setuPhoto(newFileName);

			resultCnt = templeteDao.insertMember(memberInfo);

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("구아악 이곳은 !!회워가입사진!");
		}
		return resultCnt;
	}

	public char idCheck(String id) {

		char chk = templeteDao.selectMemberById(id) == null ? 'Y' : 'N';

		return chk;
	}
	
	public String idCheck1(String id) {
		
		String chk = templeteDao.selectMemberById2(id)==null?"Y":"N" ;
		
		
		return chk;
	}

}
