package homework01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			ResultSet rs = null;
			try {
				// 1�ܰ� Connection
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(dburl, dbuser, dbpwd);

				// 2�ܰ� Statement
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
					System.out.println("ȸ������ �Ϸ�");
				}else
					System.out.println("���� ����");

				// 3�ܰ� ResultSet
				rs = pStmt.executeQuery();


				if( 1 == pStmt.executeUpdate()){    
					userVO.setActive(true);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (Exception e1) {
					}
				}
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
	
	}


