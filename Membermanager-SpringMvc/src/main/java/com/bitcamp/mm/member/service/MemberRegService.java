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
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.RequestMemberRegist;


@Service("regsitService")
public class MemberRegService implements MemberService {
	
	@Autowired
	private MemberDao dao;
	
	public int memberInsert(HttpServletRequest request, RequestMemberRegist regist) {
		//서버경로
		String path="/uploadfile/userphoto";
		//절대경로
		String dir=request.getSession().getServletContext().getRealPath(path);
		
		MemberInfo memberInfo =regist.toMemInfo();
		
		//새로운 파일을 생성
		String newFileName = memberInfo.getuId()+"_"+regist.getuPhoto().getOriginalFilename();
		
		int resultCnt=0;
		Connection conn= null;
		try {
			
			conn=ConnectionProvider.getConnection();
			//파일을 서버의 지정 경로에 저장
			System.out.println(dir);
			regist.getuPhoto().transferTo(new File(dir,newFileName));
			
			//데이터 베이스 저장을 하기우ㅏ한 파일 이름 set
			memberInfo.setuPhoto(newFileName);
			
			resultCnt=dao.insertMember(conn, memberInfo);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오류확인");
			new File(dir,newFileName).delete();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("구아악");
		}
		return resultCnt;
	}
	
	
}
