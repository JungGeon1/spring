package com.test.tb.dao;

import com.test.tb.domain.AdminTblDto;

public interface adminDao {
	//가입자입력
	public int adminInsert(AdminTblDto dto);
	//가입자 정보
	public AdminTblDto adminInfo(String a_id);
}
