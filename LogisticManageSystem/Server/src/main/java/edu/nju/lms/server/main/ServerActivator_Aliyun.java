package edu.nju.lms.server.main;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.dataService.DepartmentDataService;
import edu.nju.lms.dataService.FinanceAccountDataService;
import edu.nju.lms.dataService.FinancePaymentDataService;
import edu.nju.lms.dataService.FinanceReceiptDataService;
import edu.nju.lms.dataService.FinanceStrategyDataService;
import edu.nju.lms.dataService.ListDataService;
import edu.nju.lms.dataService.LogDataService;
import edu.nju.lms.dataService.PersonnelDataService;
import edu.nju.lms.dataService.TransportCommodityDataService;
import edu.nju.lms.dataService.TransportListDataService;
import edu.nju.lms.dataService.TransportToolDataService;
import edu.nju.lms.dataService.UserDataService;
import edu.nju.lms.dataService.WarehouseCheckinDataService;
import edu.nju.lms.dataService.WarehouseCheckoutDataService;
import edu.nju.lms.dataService.WarehouseDataService;
import edu.nju.lms.dataService.impl.DepartmentDataImpl;
import edu.nju.lms.dataService.impl.FinanceAccountDataImpl;
import edu.nju.lms.dataService.impl.FinancePaymentDataImpl;
import edu.nju.lms.dataService.impl.FinanceReceiptDataImpl;
import edu.nju.lms.dataService.impl.FinanceStrategyDataImpl;
import edu.nju.lms.dataService.impl.ListDataImpl;
import edu.nju.lms.dataService.impl.LogDataImpl;
import edu.nju.lms.dataService.impl.PersonnelDataImpl;
import edu.nju.lms.dataService.impl.TransportCommodityDataImpl;
import edu.nju.lms.dataService.impl.TransportListDataImpl;
import edu.nju.lms.dataService.impl.TransportToolDataImpl;
import edu.nju.lms.dataService.impl.UserDataImpl;
import edu.nju.lms.dataService.impl.WarehouseCheckinDataImpl;
import edu.nju.lms.dataService.impl.WarehouseCheckoutDataImpl;
import edu.nju.lms.dataService.impl.WarehouseDataImpl;

public class ServerActivator_Aliyun {

	public ServerActivator_Aliyun(){

	}

	public static void main( String[] args ){
		ServerActivator_Aliyun activator = new ServerActivator_Aliyun();
		activator.activateServer();
	}
	public void activateServer(){
		String url = "jdbc:mysql://127.0.0.1:3306/lms?useUnicode=true&characterEncoding=utf8";
		JDBC.createJDBC(url,"root","0194ccbbhh");

		try{    

			String hostIP = InetAddress.getLocalHost().getHostAddress();
			int rmiServerPort = 8400;  //数据传输服务为8400
			System.setProperty("java.rmi.server.hostname","192.168.31.53");
			RMISocketFactory.setSocketFactory(new SMRMISocket());  //定义数据传输端口 8500
			LocateRegistry.createRegistry(rmiServerPort); //定义服务注册与查找服务端口 8400
 

			UserDataService userDataService = new UserDataImpl();  
			FinanceAccountDataService financeAccountDataService = new FinanceAccountDataImpl();
			DepartmentDataService departmentDataService = new DepartmentDataImpl();
			FinancePaymentDataService financePaymentDataService = new FinancePaymentDataImpl();
			FinanceReceiptDataService financeReceiptDataService = new FinanceReceiptDataImpl();
			FinanceStrategyDataService financeStrategyDataService = new FinanceStrategyDataImpl();
			PersonnelDataService personnelDataService = new PersonnelDataImpl();  
			TransportCommodityDataService transportCommodityDataService = new TransportCommodityDataImpl();
			TransportToolDataService transportToolDataService = new TransportToolDataImpl();
			WarehouseCheckinDataService warehouseCheckinDataService = new WarehouseCheckinDataImpl();
			WarehouseCheckoutDataService warehouseCheckoutDataService = new WarehouseCheckoutDataImpl();
			ListDataService listDataService = new ListDataImpl();
			LogDataService logDataService = new LogDataImpl();
			TransportListDataService transportListDataService = new TransportListDataImpl();
			WarehouseDataService warehouseDataService = new WarehouseDataImpl();


			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/UserDataService", userDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/FinanceAccountDataService", financeAccountDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/DepartmentDataService", departmentDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/FinancePaymentDataService", financePaymentDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/FinanceReceiptDataService", financeReceiptDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/FinanceStrategyDataService", financeStrategyDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/PersonnelDataService", personnelDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/TransportCommodityDataService", transportCommodityDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/TransportToolDataSevice", transportToolDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/TransportToolDataService",transportToolDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/WarehouseCheckinDataService", warehouseCheckinDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/WarehouseCheckoutDataService", warehouseCheckoutDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/ListDataService", listDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/LogDataService", logDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/TransportListDataService",transportListDataService);
			Naming.rebind("//"+hostIP+":"+rmiServerPort+"/WarehouseDataService",warehouseDataService);
			
			System.out.println("Server is ready.");    
		}catch (Exception e){    
			System.err.println("Server failed: \n" + e);    
		}    
	}

}
