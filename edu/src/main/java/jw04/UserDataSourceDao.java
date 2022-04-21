package jw04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDataSourceDao {
	// Field
	// String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	// String dbuser = "scott";
	// String dbpwd = "tiger";

	// Constructor
	public UserDataSourceDao() {

	}

	// Method
	public void getUser(UserVO userVO) {
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			// 1�ܰ� Connection
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection(dburl, dbuser, dbpwd);

			// ==> OracleConnectionPool�κ��� Connection �ν��Ͻ� Get
			//con = OracleConnectionPool.getInstance().getConnection;
			
			//=============================================================//
			// ==> DataSource ���� connection Get
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/ora");
												//==> java:comp  : naming service root
												//==> env  :enviroment
												//==> jdbc/ora : server.xml�� ��ϵ� name
			con = ds.getConnection();
			
			//=============================================================//
			
			
			// 2�ܰ� Statement
			pStmt = con.prepareStatement("SELECT id, pwd FROM users WHERE id = ? AND pwd = ?");
			pStmt.setString(1, userVO.getId());
			pStmt.setString(2, userVO.getPwd());

			// 3�ܰ� ResultSet
			rs = pStmt.executeQuery();

			if (rs.next()) {
				System.out.println("db���� Ȯ���� id, pwd ==> " + userVO.getId() + " : " + userVO.getPwd());
				// ==> Data�� �����Ѵٸ�..
				userVO.setActive(true);
			} else {
				System.out.println("db�� < " + userVO.getId() + " > �� �ش��ϴ� �ڷᰡ �����ϴ�. ");

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
