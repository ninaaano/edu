package jw.common.dao;

// ������Ʈ �����ϱ�

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
				System.out.println("ȸ������ �Ϸ�");
			}else
				System.out.println("���� ����");
			
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
				System.out.println("db���� Ȯ�� �� id,pwd ==>:"+userVO.getId()+":"+userVO.getPwd());
				userVO.setActive(true);
			}else{
				System.out.println("db�� <"+userVO.getId()+">�� �ش��ϴ� �ڷᰡ �����ϴ�.");
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