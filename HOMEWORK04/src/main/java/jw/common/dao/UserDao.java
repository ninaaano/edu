package jw.common.dao;

// 업데이트 구현하기

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jw.common.dao.AbstractDao;
import jw.service.user.vo.UserVO;

public class UserDao extends AbstractDao {
	public UserDao() {
	}
	public void addUser(UserVO userVO) {
		Connection con = null;
		PreparedStatement pStmt = null;
				
		try {
			con = this.connect();
			pStmt = con.prepareStatement("INSERT into tbl_users values(?,?,?,?,?,?,?)");
			pStmt.setString(1, userVO.getId());
			pStmt.setString(2, userVO.getPwd());
			pStmt.setString(3, userVO.getGender());
			pStmt.setString(4, userVO.getBirth());
			pStmt.setString(5, userVO.getJob());
			pStmt.setString(6, userVO.getTel());
			pStmt.setString(7, userVO.getAddr());

			if (1 == pStmt.executeUpdate()) {
				userVO.setActive(true);
				System.out.println("회원가입 완료");
			}else
				System.out.println("가입 실패");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(con, pStmt);
		}
		
	}
	public UserVO findUser(String id){
		UserVO userVO = new UserVO();
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try{
			con = this.connect();

			pStmt = con.prepareStatement("SELECT id,pwd FROM users WHERE id =?");
			pStmt.setString(1,id);
			

			rs=pStmt.executeQuery();
			
			if(rs.next()){
				System.out.println("db에서 확인 한 id,pwd ==>:"+userVO.getId()+":"+userVO.getPwd());
				userVO.setActive(true);
			}else{
				System.out.println("db에 <"+userVO.getId()+">에 해당하는 자료가 없습니다.");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(con,pStmt,rs);
		}
	}



	public void updateUser(UserVO userVO){
		Connection con = null;
		PreparedStatement pStmt = null;
		
		try{
			con = this.connect();
			pStmt = con.prepareStatement("");

			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(con,pStmt,rs);
			}
			
		}
	}
}