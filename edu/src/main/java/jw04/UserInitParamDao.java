package jw04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Ư�� DBMS�� ���������� ���� DAO
public class UserInitParamDao {

	// Field
	private String jdbcDriver;
	private String jdbcURL;
	private String jdbcUser;
	private String jdbcPasswd;

	public UserInitParamDao() {

	}

	// Method
	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public void setJdbcURL(String jdbcURL) {
		this.jdbcURL = jdbcURL;
	}

	public void setJdbcUser(String jdbcUser) {
		this.jdbcUser = jdbcUser;
	}

	public void setJdbcPasswd(String jdbcPasswd) {
		this.jdbcPasswd = jdbcPasswd;
	}

	public void getUser(UserVO userVO) {
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			// 1�ܰ� Connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPasswd);
			
			// 2�ܰ� statement
			pStmt = con.prepareStatement("SELECT id, pwd FROM users WHERE id = ? AND pwd=?");
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
				} catch (Exception e1) {}
			}
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch (Exception e2) {}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e3) {}

			}
	}

  }
}
