package jdbc_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class TestDB {

	public static void main(String[] args) throws SQLException {
		OracleDriver driver=new OracleDriver();
		DriverManager.registerDriver(driver);
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		Connection conn=DriverManager.getConnection(url,"scott","tiger");
		System.out.println("connected");
		Statement st=conn.createStatement();
//	String qry="insert into test1 values(313,'Pranavi',1234)";
//	st.executeUpdate(qry);
//		System.out.println("updated");
		String qry="insert into test1 values(?,?,?)";
		PreparedStatement pst=conn.prepareStatement(qry);
		pst.setInt(1,314);
		pst.setString(2, "Ryakala");
		pst.setDouble(3,231);
		pst.setInt(1,315);
		pst.setString(2, "Deloitte.");
		pst.setDouble(3,2312);
		pst.setInt(1,316);
		pst.setString(2, "Deloitte.");
		pst.setDouble(3,2312);
		Scanner sc=new Scanner(System.in);
		boolean b=true;
		do
		{System.out.println("Enter EmpID: ");
		pst.setInt(1,sc.nextInt());
		System.out.println("Enter Name: ");
		pst.setString(2, sc.next());
		System.out.println("Enter Salary: ");
		pst.setDouble(3,sc.nextDouble());		
		String str;
		
		int rows=pst.executeUpdate();
		System.out.println("want to enter more? true/false: ");
		str=sc.next();
	
		if(str=="yes")
			b=true;
		else
			b=false;
		System.out.println(rows);

		System.out.println("inserted");
		
	}
		while(b==true);
		
	}
}
