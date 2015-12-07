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
			System.err.println("Execution failed!!!");
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
			System.err.println("Execution failed!!!");
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
			System.err.println("Sorry,can`t find the Driver!"); 
		} catch(SQLException e) {
			System.err.println("The MySql can't be connected!");
		} catch(Exception e) {
			System.err.println("Create JDBC failed due to UNKNOWN reason");
		} 
	}
}
