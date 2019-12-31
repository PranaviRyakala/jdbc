package jdbc_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class Retrival {

	public static void main(String[] args) throws SQLException {
		OracleDriver driver=new OracleDriver();
		DriverManager.registerDriver(driver);
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		Connection conn=DriverManager.getConnection(url,"scott","tiger");
		System.out.println("connected");
		String str="select * from test1";
		PreparedStatement pst=conn.prepareStatement(str);
		ResultSet rs=pst.executeQuery();
	ResultSetMetaData rsmd=rs.getMetaData();
	for(int i=1;i<=rsmd.getColumnCount();i++)
		System.out.print(rsmd.getColumnName(i)+" ");
	System.out.println("\n--------------------------");
	while(rs.next())
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));

	}

}
