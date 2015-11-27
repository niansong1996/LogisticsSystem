package edu.nju.lms.data.utility;

import java.sql.*;

public class JDBC {
	private static Connection conn;
	private static String driver = "com.mysql.jdbc.Driver";

	public static ResultSet ExecuteQuery(String sql){
//		System.out.println(sql);
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
//		System.out.println(sql);
		ResultSet result = null;
		try {
			Statement statement = conn.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			System.out.println("Execution failed!!!");
		}
		return result;
	}
	private JDBC(){}
	public static void createJDBC(String url,String user,String password){

		try { 
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed()) System.out.println("Succeeded connecting to the Database!");
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
