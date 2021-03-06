package comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/mybooks";
	private static final String UNAME="root";
	private static final String UPASS="123456";
	public static Connection getCon() throws SQLException{
		Connection con=null;
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,UNAME,UPASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void allClose(Connection con,PreparedStatement pstmt,ResultSet rs){
		
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(pstmt!=null){
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
