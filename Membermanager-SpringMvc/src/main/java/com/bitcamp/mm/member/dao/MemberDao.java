package com.bitcamp.mm.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bitcamp.mm.jdbc.JdbcUtil;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.SearchParam;

@Repository("dao")
public class MemberDao {

	public MemberInfo selectMemberById(Connection conn, String userId) {

		MemberInfo memberInfo = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("dao : memberId -> " + userId);

		String sql = "select * from project.userinfo where mid=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				System.out.println("check ::::::::::::::::::::::::");
				memberInfo = new MemberInfo(rs.getInt("idx"), rs.getString("mid"), rs.getString("mpw"),
						rs.getString("mname"), rs.getString("mphoto"), new Date(rs.getTimestamp("regdate").getTime()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return memberInfo;
	}

	public int insertMember(Connection conn, MemberInfo memberInfo) {

		PreparedStatement pstmt = null;

		int rCnt = 0;

		// String sql = "insert into userinfo(idx,mid,mpw,mname,mphoto)
		// values(userinfo_idx_seq.nextval,?,?,?,?) ";
		String sql = "insert into project.userinfo(mid,mpw,mname,mphoto) values(?,?,?,?) ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getuId());
			pstmt.setString(2, memberInfo.getuPW());
			pstmt.setString(3, memberInfo.getuName());
			pstmt.setString(4, memberInfo.getuPhoto());
			rCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rCnt;

	}

	public List<MemberInfo> selectList(Connection conn, int index, int count) {

		List<MemberInfo> memberList = new ArrayList<MemberInfo>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM project.userinfo limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			pstmt.setInt(2, count);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberList.add(new MemberInfo(rs.getInt("idx"), rs.getString("mId"), rs.getString("mPw"),
						rs.getString("mName"), rs.getString("mPhoto"), new Date(rs.getDate("regdate").getTime())));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return memberList;
	}

	public int selectTotalCount(Connection conn, SearchParam searchParam) {

		int totalCnt = 0;

		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from project.userInfo";

		if (searchParam != null) {
			sql = "select count(*) from project.userInfo where ";
			if (searchParam.getStype().equals("both")) {
				sql += " mid like '%" + searchParam.getKeyword() + "%' or mname  like '%" + searchParam.getKeyword()
						+ "%' ";
			}
			if (searchParam.getStype().equals("id")) {
				sql += " mid  like '%" + searchParam.getKeyword() + "%'";
			}
			if (searchParam.getStype().equals("name")) {
				sql += " mname  like '%" + searchParam.getKeyword() + "%' ";
			}
		}

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				totalCnt = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totalCnt;
	}

	public List<MemberInfo> selectListById(Connection conn, int index, int count, SearchParam searchParam) {

		List<MemberInfo> memberList = new ArrayList<MemberInfo>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM project.userInfo where mid like ?  limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchParam.getKeyword() + "%");
			pstmt.setInt(2, index);
			pstmt.setInt(3, count);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberList.add(new MemberInfo(rs.getInt("idx"), rs.getString("mId"), rs.getString("mPw"),
						rs.getString("mName"), rs.getString("mPhoto"), new Date(rs.getDate("regdate").getTime())));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return memberList;
	}

	public List<MemberInfo> selectListByName(Connection conn, int index, int count, SearchParam searchParam) {

		List<MemberInfo> memberList = new ArrayList<MemberInfo>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM project.userInfo where mname like ?  limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchParam.getKeyword() + "%");
			pstmt.setInt(2, index);
			pstmt.setInt(3, count);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberList.add(new MemberInfo(rs.getInt("idx"), rs.getString("mId"), rs.getString("mPw"),
						rs.getString("mName"), rs.getString("mPhoto"), new Date(rs.getDate("regdate").getTime())));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return memberList;
	}

	public List<MemberInfo> selectListByBoth(Connection conn, int index, int count, SearchParam searchParam) {

		List<MemberInfo> memberList = new ArrayList<MemberInfo>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM project.userInfo where mid like ? or  mname like ?  limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchParam.getKeyword() + "%");
			pstmt.setString(2, "%" + searchParam.getKeyword() + "%");
			pstmt.setInt(3, index);
			pstmt.setInt(4, count);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberList.add(new MemberInfo(rs.getInt("idx"), rs.getString("mId"), rs.getString("mPw"),
						rs.getString("mName"), rs.getString("mPhoto"), new Date(rs.getDate("regdate").getTime())));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return memberList;
	}



	public MemberInfo selectMemberByIdx(Connection conn, int id) {

		MemberInfo memberInfo = null;
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		System.out.println("dao : memberId -> " + id);
		
		String sql = "select * from project.userinfo where idx=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				System.out.println("check ::::::::::::::::::::::::");
				memberInfo = new MemberInfo(
					rs.getInt("idx"), 
					rs.getString("mid"), 
					rs.getString("mpw"), 
					rs.getString("mname"), 
					rs.getString("mphoto"), 
					new Date(rs.getTimestamp("regdate").getTime()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		
		return memberInfo;
	}

	public int memberUpdate(Connection conn, MemberInfo memberInfo) {
		
		System.out.println(">>>>>>>>>>>"+memberInfo);
		int rCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "update project.userinfo set mname=?, mpw=?, mphoto=? where idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getuName());
			pstmt.setString(2, memberInfo.getuPW());
			pstmt.setString(3, memberInfo.getuPhoto());
			pstmt.setInt(4, memberInfo.getIdx());
			rCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return rCnt;
		
	}
	
	public int memberDelete(Connection conn, int messageId) {

		int resultCnt = 0;

		PreparedStatement pstmt = null;

		String sql = "delete from project.UserInfo where idx =?";

		try {
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, messageId);

				resultCnt = pstmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;

	}
	/*
	 * public int upda(Connection conn, MemberInfo memberInfo) {
	 * 
	 * int rCnt=0;
	 * 
	 * 
	 * PreparedStatement pstmt= null; String
	 * sql="update project.userinfo set mname=?, mpw=?, mphoto=? where idx=?";
	 * 
	 * try { pstmt= conn.prepareStatement(sql); pstmt.setString(1,
	 * memberInfo.getuName()); pstmt.setString(2, memberInfo.getuPW());
	 * pstmt.setString(3, memberInfo.getuPhoto()); pstmt.setInt(4,
	 * memberInfo.getIdx());
	 * 
	 * rCnt=pstmt.executeUpdate(); } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * 
	 * return rCnt;
	 * 
	 * }
	 */
	

}
