package com.petsite.members.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petsite.members.dao.MemberDao;
import com.petsite.members.domain.MemberInfo;

@Service("mypageService")
public class MypageService {

	@Autowired
	private SqlSessionTemplate template;
	private MemberDao dao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	// 내 정보 불러오기
	public MemberInfo myInfo(String id) {

		dao = template.getMapper(MemberDao.class);

		MemberInfo memberInfo = dao.selectById(id);

		return memberInfo;
	}

	// 사진 업로드
	public int editProcess(HttpServletRequest request, MemberInfo memberInfo) {

		dao = template.getMapper(MemberDao.class);

		// 사진 저장 경로
		String path = "/file";
		String dir = request.getSession().getServletContext().getRealPath(path);

		int rCnt = 0;
		String newFileName = "";

		if (memberInfo.getPic() != null) {
			newFileName = memberInfo.getId() + "_" + memberInfo.getPic().getOriginalFilename();

			try {

				memberInfo.getPic().transferTo(new File(dir, newFileName));
				memberInfo.setPic_name(newFileName);

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// DB저장
		rCnt = dao.updateMem(memberInfo);

		return rCnt;
	}

	public int editProcess(MemberInfo memberInfo) {

		dao = template.getMapper(MemberDao.class);

		int cnt = 0;

		System.out.println("editProcess"+memberInfo);

		// 비밀번호 암호화
		memberInfo.setPw(encoder.encode(memberInfo.getPw()));
		
		// 주소 재설정 (기본주소 + 상세주소)
		memberInfo.setAddress(memberInfo.addAddress());
		
		// DB저장
		cnt = dao.updateMem(memberInfo);
		
		System.out.println("editProcess"+cnt);
		return cnt;
	}
	
	// 회원 탈퇴
	public int deleteMem(String id) {
		
		dao = template.getMapper(MemberDao.class);
		
		int cnt = 0;
		
		cnt = dao.deleteMem(id);
		System.out.println("deleteMemService"+cnt);
		
		return cnt;
	}
}
