package edu.nju.lms.server.main;

import edu.nju.lms.sql.JDBC;

public class ServerActivator 
{
	public static void main( String[] args ){
		ServerActivator activator = new ServerActivator();
		activator.activateServer();
	}
	public void activateServer(){
		String url = "jdbc:mysql://127.0.0.1:3306/lms";
		String user = "root";
		String password = "9990";
		JDBC CommonJDBC = new JDBC(url,user,password);
	}
}
