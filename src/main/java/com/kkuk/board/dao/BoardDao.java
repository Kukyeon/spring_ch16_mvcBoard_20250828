package com.kkuk.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kkuk.board.dto.BoardDto;

public class BoardDao {

	private String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/springdb?serverTimezone=Asia/Seoul";
	private String username = "root";
	private String password = "12345";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public void write(String bname, String btitle, String bcontent) { // DB 에 글 쓰는 메소드
		String sql = "INSERT INTO boardtbl(bname, btitle, bcontent, bhit) " 
					+ " VALUES (?,?,?,0) ";
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<BoardDto> boardlist() { // DB 에 있는 게시판 모든 글 목록 가져오기
		String sql = "SELECT * FROM boardtbl ORDER BY bnum DESC";
		List<BoardDto> bDtos = new ArrayList<BoardDto>();
		
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				
		BoardDto bDto = new BoardDto(rs.getInt("bnum"), rs.getString("btitle"), rs.getString("bcontent"), rs.getString("bname"), rs.getInt("bhit"), rs.getString("bdate"));
		bDtos.add(bDto);
			
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return bDtos;
	}
	
	public BoardDto contentview(String bnum) {// 글 번호의 해당하는 글의 레코드를 가져와서 boardDto에 넣어서 반환하는 메서드
		uphit(bnum); // 조회수 증가 함수 호출
		String sql = "SELECT * FROM boardtbl WHERE bnum = ? ";
		BoardDto bDto = new BoardDto();
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bnum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				bDto = new BoardDto(rs.getInt("bnum"), rs.getString("btitle"), rs.getString("bcontent"), rs.getString("bname"), rs.getInt("bhit"), rs.getString("bdate"));
			
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return bDto;
		
	}
	
	public void uphit(String bnum) { //유저가 클릭한 게시글의 조회수 증가
		String sql = "UPDATE boardtbl SET bhit=bhit+1 WHERE bnum=?";
	try {
		Class.forName(driverName);
		conn = DriverManager.getConnection(url, username, password);
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, bnum);
		
		
		pstmt.executeUpdate();
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
		
	}


