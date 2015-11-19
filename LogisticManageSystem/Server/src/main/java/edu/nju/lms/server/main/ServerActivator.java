package edu.nju.lms.server.main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import edu.nju.lms.dataService.UserDataService;
import edu.nju.lms.dataService.impl.UserDataImpl;
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
		
		 try{    
	         LocateRegistry.createRegistry(1099);    
	         UserDataService userDataService = new UserDataImpl();    
	              
	         Naming.rebind("UserDataService", userDataService);    
	             
	         //如果要把实例注册到另一台启动了RMI注册服务的机器上    
	         //Naming.rebind("//192.168.1.105:1099/Hello",hello);    
	            
	         System.out.println("Server is ready.");    
	      }    
	      catch (Exception e){    
	         System.out.println("Server failed: " + e);    
	      }    
	}
}
