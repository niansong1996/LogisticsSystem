package edu.nju.lms.server.main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

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
import edu.nju.lms.dataService.TransportToolDataService;
import edu.nju.lms.dataService.UserDataService;
import edu.nju.lms.dataService.WarehouseCheckinDataService;
import edu.nju.lms.dataService.WarehouseCheckoutDataService;
import edu.nju.lms.dataService.impl.DepartmentDataImpl;
import edu.nju.lms.dataService.impl.FinanceAccountDataImpl;
import edu.nju.lms.dataService.impl.FinancePaymentDataImpl;
import edu.nju.lms.dataService.impl.FinanceReceiptDataImpl;
import edu.nju.lms.dataService.impl.FinanceStrategyDataImpl;
import edu.nju.lms.dataService.impl.ListDataImpl;
import edu.nju.lms.dataService.impl.LogDataImpl;
import edu.nju.lms.dataService.impl.PersonnelDataImpl;
import edu.nju.lms.dataService.impl.TransportCommodityDataImpl;
import edu.nju.lms.dataService.impl.TransportToolDataImpl;
import edu.nju.lms.dataService.impl.UserDataImpl;
import edu.nju.lms.dataService.impl.WarehouseCheckinDataImpl;
import edu.nju.lms.dataService.impl.WarehouseCheckoutDataImpl;

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
		JDBC.createJDBC(url,user,password);
		
		 try{    
	         LocateRegistry.createRegistry(1099);    
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
	         
	         Naming.rebind("UserDataService", userDataService);
	         Naming.rebind("FinanceAccountDataService", financeAccountDataService);
	         Naming.rebind("DepartmentDataService", departmentDataService);
	         Naming.rebind("FinancePaymentDataService", financePaymentDataService);
	         Naming.rebind("FinanceReceiptDataService", financeReceiptDataService);
	         Naming.rebind("FinanceStrategyDataService", financeStrategyDataService);
	         Naming.rebind("PersonnelDataService", personnelDataService);
	         Naming.rebind("TransportCommodityDataService", transportCommodityDataService);
	         Naming.rebind("TransportToolDataSevice", transportToolDataService);
	         Naming.rebind("TransportToolDataService",transportToolDataService);
	         Naming.rebind("WarehouseCheckinDataService", warehouseCheckinDataService);
	         Naming.rebind("WarehouseCheckoutDataService", warehouseCheckoutDataService);
	         Naming.rebind("ListDataService", listDataService);
	         Naming.rebind("LogDataService", logDataService);
	         
	         
	         //如果要把实例注册到另一台启动了RMI注册服务的机器上    
	         //Naming.rebind("//192.168.1.105:1099/Hello",hello);    
	            
	         System.out.println("Server is ready.");    
	      }    
	      catch (Exception e){    
	         System.err.println("Server failed: \n" + e);    
	      }    
	}
}
