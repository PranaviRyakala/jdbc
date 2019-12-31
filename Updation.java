package jdbc_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class Updation {

	public static void main(String[] args) throws SQLException {
		OracleDriver driver=new OracleDriver();
		DriverManager.registerDriver(driver);
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		Connection conn=DriverManager.getConnection(url,"scott","tiger");
		System.out.println("connected");
		String str="update test1 set empname=?, salary=? where empid=?";
		PreparedStatement pst=conn.prepareStatement(str);
		pst.setString(1, "qwerty");
		pst.setDouble(2, 234);
		pst.setInt(3, 314);
		int rows=pst.executeUpdate();
		System.out.println(rows);
conn.close();
	}

}
