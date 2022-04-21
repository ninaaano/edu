package homework02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jw.common.pool.OracleConnectionPool;
import homework02.UserVO;

public class UserDAO {
	
	String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String dbuser = "scott";
	String dbpwd = "tiger";
	
	public UserDAO() {
	}
		// Method
		public void addUser(UserVO userVO){
			Connection con = null;
			PreparedStatement pStmt = null;
			
			try {
				// 1단계 Connection
				
				con = OracleConnectionPool.getInstance().getConnection();

				// 2단계 Statement
				pStmt = con.prepareStatement("INSERT into tbl_users values(?,?,?,?,?,?,?)");
				pStmt.setString(1, userVO.getId());
				pStmt.setString(2, userVO.getPwd());
				pStmt.setString(3, userVO.getGender());
				pStmt.setString(4, userVO.getBirth());
				pStmt.setString(5, userVO.getJob());
				pStmt.setString(6, userVO.getTel());
				pStmt.setString(7, userVO.getAddr());
				
				int ret = pStmt.executeUpdate();
				
				if(ret==1) {
					userVO.setActive(true);
					System.out.println("회원가입 완료");
				}else
					System.out.println("가입 실패");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				if (pStmt != null) {
					try {
						pStmt.close();
					} catch (Exception e2) {
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e3) {
					}

				}
			}
		}
	public UserVO findUser(String id){
		
		UserVO userVO = new UserVO();
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
	
		try{
			con = OracleConnectionPool.getInstance().getConnection();
			pStmt = con.prepareStatement("SELECT * FROM tbl_users where id = ?");
			pStmt.setString(1,id);
		
			
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				userVO.setId(rs.getString("id"));
				userVO.setPwd(rs.getString("pwd"));
				userVO.setGender(rs.getString("gender"));
				userVO.setBirth(rs.getString("birth"));
				userVO.setJob(rs.getString("job"));
				userVO.setTel(rs.getString("tel"));
				userVO.setAddr(rs.getString("addr"));
				System.out.println(userVO + "완료");
			
			}else {
				System.out.println("실패");
			}
		}catch(Exception e){		
			e.printStackTrace();
		}finally{
			//각각의 DB와 관련된 객체 close
			if(rs != null){
				try{	
					rs.close();	
				}catch(final Exception e1){  }
			}
			if(pStmt != null){
				try{	
					pStmt.close();	
				}catch(final Exception e2){  }
			}
			if(con != null){
				try{	
					con.close();	
				}catch(final Exception e3){  }
			}
		}
		return userVO;	
	}
	
}



