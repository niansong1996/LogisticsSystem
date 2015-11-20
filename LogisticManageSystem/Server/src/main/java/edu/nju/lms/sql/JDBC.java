package edu.nju.lms.sql;

import java.sql.*;

public class JDBC {
	static Connection conn;
	Statement statement;
	String driver = "com.mysql.jdbc.Driver";

	public static ResultSet ExecuteQuery(String sql){
		ResultSet result = null;
		try {
			Statement statement = conn.createStatement();
			result = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static ResultSet ExecuteData(String sql){
		ResultSet result = null;
		try {
			Statement statement = conn.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			System.out.println("Execution failed!!!");
		}
		return result;
	}

	public JDBC(String url,String user,String password){
		//TODO to be modified into actual url, user and password

		try { 
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed()) System.out.println("Succeeded connecting to the Database!");
			Statement statement = conn.createStatement();
			/*
			String sql = "select * from person";	         

			// 结果集
			ResultSet rs = statement.executeQuery(sql);

			System.out.println("-----------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-----------------");
			System.out.println("-----------------");

			while(rs.next()) {
				System.out.println(rs.getString(1)+"  "+rs.getString(2));
			}

			rs.close();
			conn.close();
			 */
		} catch(ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!"); 
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
}
