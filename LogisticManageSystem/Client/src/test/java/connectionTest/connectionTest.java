package connectionTest;

import java.rmi.Naming;

import edu.nju.lms.PO.UserPO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.dataService.UserDataService;

public class connectionTest {
	static UserPO userPo1 = new UserPO("1234567899","999",PersonType.MANAGER);
	static UserPO userPo2 = new UserPO("7364534263","876567",PersonType.ADMINISTRATOR);
	public static void main(String[] argv){    
	      try{    
	         UserDataService userData = (UserDataService) Naming.lookup("//127.0.0.1:1099/UserDataService");    
	             
	         //如果要从另一台启动了RMI注册服务的机器上查找hello实例    
	         //HelloInterface hello = (HelloInterface)Naming.lookup("//192.168.1.105:1099/Hello");    
	            userData.addUser(userPo2); 
	      }    
	      catch (Exception e){    
	         System.out.println("HelloClient exception: " + e);    
	      }    
	   }    
	
}
