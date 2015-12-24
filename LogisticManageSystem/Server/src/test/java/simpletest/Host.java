package simpletest;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

import edu.nju.lms.dataService.UserDataService;
import edu.nju.lms.dataService.impl.UserDataImpl;
import edu.nju.lms.server.main.SMRMISocket;

public class Host {
	public static void main(String[] args) throws UnknownHostException{
		String hostIP = InetAddress.getLocalHost().getHostAddress();
		int rmiServerPort = 8400;  //数据传输服务为8400
		String bindName = "UserDataService";
		//下面这行代码不能少，否则当路由器x.x.x.135映射到的内网IP：x.x.x.90时，
		//访问RMI服务时将导向本地的x.x.x.90，那么客户端就是访问本地x.x.x.90，
		//这绝对错误.服务是在公网路由器（含公共IP）的后面，不在客户的本地
		System.setProperty("java.rmi.server.hostname","139.129.40.103");
		try {
			RMISocketFactory.setSocketFactory(new SMRMISocket());  //定义数据传输端口 8500
			LocateRegistry.createRegistry(rmiServerPort); //定义服务注册与查找服务端口 8400
		}
		catch (Exception ex) {
			System.out.println("服务器端口绑定时发生错误:"+ex.getMessage());
			ex.printStackTrace();
		}
		//创建license生成器的服务对象
		UserDataService userData = null;
		try {
			userData = new UserDataImpl();

			//绑定一个服务对象到一个服务端口
			//URL format (without the scheme component)
			String bindUrl = "//"+hostIP+":"+ rmiServerPort +"/"+bindName;
			Naming.rebind(bindUrl, userData);
			System.out.println(bindUrl+" server is ready.");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
