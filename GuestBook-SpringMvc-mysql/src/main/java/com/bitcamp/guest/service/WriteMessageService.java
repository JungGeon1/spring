package com.bitcamp.guest.service;
/* 2019-08-05 mon
 * */
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bitcamp.guest.dao.MessageDao;
import com.bitcamp.guest.dao.MessageJdbcTemplateDao;
import com.bitcamp.guest.dao.MessageSessionDao;
import com.bitcamp.guest.dao.MessageSessionTemplateDao;
import com.bitcamp.guest.domain.Message;
import com.bitcamp.guest.jdbc.ConnectionProvider;


@Service("writeService")
public class WriteMessageService implements GuestBookService{

/* 2019-08-05 에 작성한 내용
	@Autowired
	private MessageDao dao;
	
	
	public int write(Message message) {
		int result = 0;

		Connection conn = null;

		try {

			conn = ConnectionProvider.getConnection();

			result = dao.insert(conn, message);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
*/

	/*---------------------------------------------------------
				2019-08-08에 jdbc템플릿으로 변경
	---------------------------------------------------------*/
	
	//@Autowired
	//private MessageSessionTemplateDao templateDao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MessageSessionDao templateDao;
	
    
	
	public int write(Message message) {
		templateDao= template.getMapper(MessageSessionDao.class);
		
		int result = 0;
		result = templateDao.insert(message);
		return result;
	}
}
