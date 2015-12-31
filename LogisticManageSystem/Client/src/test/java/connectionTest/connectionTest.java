package connectionTest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.lms.dataService.UserDataService;

public class connectionTest {
	public static void main(String[] args){    
		connectionTest test = new connectionTest();
		test.run();
	} 

	
	public void run(){
		String remoteHost = "139.129.40.103";   //公网IP或局域网IP
		int rmiServerPort=8400;  //查找服务端口 8400
		String bindName = "UserDataService";   //RMI服务名称
		int revCount = 0;
		UserDataService userData=null;
		try{
			//	      if(System.getSecurityManager()==null){
			//	        System.setSecurityManager(new RMISecurityManager());
			//	      }
			String bindUrl = "//"+remoteHost+":"+ rmiServerPort +"/"+bindName;
			System.out.println("请求的远程服务URL="+bindUrl);
			userData = (UserDataService) Naming.lookup(bindUrl);
			System.out.println(userData.findUser("0101017001").getPower());
			//	      System.out.print("远程remoteObject="+remoteObject);
		}
		catch (RemoteException re) {
			System.out.println("RemoteException:" + re);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
