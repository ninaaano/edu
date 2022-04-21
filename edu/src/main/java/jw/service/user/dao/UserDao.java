package jw.service.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jw.common.dao.AbstractDao;
import jw.service.user.vo.UserVO;

public class UserDao extends AbstractDao{

	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	public void getUser(UserVO userVO) {
		Connection con = null;
		PreparedStatement pStmt =null;
		ResultSet rs = null;
		try {
			con=this.connect();
			
			pStmt = con.prepareStatement("SELECT id, pwd FROM users WHERE id=? AND pwd=?");
			pStmt.setString(1, userVO.getId());
			pStmt.setString(2, userVO.getPwd());
			
			rs=pStmt.executeQuery();
			if(rs.next()) {
				System.out.println("db에서 확인 한id,pwd==>"+userVO.getId()+":"+userVO.getPwd());
				userVO.setActive(true);
			}else {
				System.out.println("db에<"+userVO.getId()+">에 해당하는 자료가 없습니다.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.close(con,pStmt,rs);
		}
	}
	
	public boolean addUser(UserVO userVO) {
		Connection con =null;
		PreparedStatement pStmt =null;
		boolean insertResult =false;
		try {
			con = this.connect();
			
			pStmt = con.prepareStatement("INSERT"+"INTO users(no,id,pwd)"+"VALUES(?,?,?)");
			pStmt.setInt(1, userVO.getNo());
			pStmt.setString(2, userVO.getId());
			pStmt.setString(3, userVO.getPwd());
			
			if(1==pStmt.executeUpdate()) {
				insertResult=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.close(con,pStmt);
		}
		return insertResult;
	}
	
	public ArrayList<UserVO> getUserList(){
		ArrayList<UserVO> arrayList = new ArrayList<UserVO>();
		
		Connection con = null;
		PreparedStatement pStmt =null;
		ResultSet rs = null;
		
		try {
			con = this.connect();
			
			pStmt = con.prepareStatement("SELECT no, id, pwd FROM users ORDER BY no");
			
			rs = pStmt.executeQuery();
			
			while(rs.next()) {
				UserVO userVO = new UserVO();
				userVO.setNo(rs.getInt("no"));
				userVO.setPwd(rs.getString("pwd"));
				userVO.setId(rs.getString("id"));
				
				System.out.println(userVO);
				
				arrayList.add(userVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.close(con,pStmt, rs);
		}
		return arrayList;
	}
}
