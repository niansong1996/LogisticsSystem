package edu.nju.lms.businessLogicService.impl.utility;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

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

public class DataServiceFactory {
	private static String IPAddress = "127.0.0.1";
	private static String portNum = "1099";
	private static Remote getDataService(String dataServiceName){
		try {
			return Naming.lookup("//"+IPAddress+":"+portNum+"/"+dataServiceName);
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Other Exception:\n");
			e.printStackTrace();
		}
		return null;
	}
	public static DepartmentDataService getDepartmentDataService(){
		return (DepartmentDataService) DataServiceFactory.getDataService("DepartmentDataService");
	}
	public static FinanceAccountDataService getFinanceAccountDataService(){
		return (FinanceAccountDataService) DataServiceFactory.getDataService("DepartmentDataService");
	}
	public static FinancePaymentDataService getFinancePaymentDataService(){
		return (FinancePaymentDataService) DataServiceFactory.getDataService("FinancePaymentDataService");
	}
	public static FinanceReceiptDataService getFinanceReceiptDataService(){
		return (FinanceReceiptDataService) DataServiceFactory.getDataService("FinanceReceiptDataService");
	}
	public static FinanceStrategyDataService getFinanceStrategyDataService(){
		return (FinanceStrategyDataService) DataServiceFactory.getDataService("FinanceStrategyDataService");
	}
	public static ListDataService getListDataService(){
		return (ListDataService) DataServiceFactory.getDataService("ListDataService");
	}
	public static LogDataService getLogDataService(){
		return (LogDataService) DataServiceFactory.getDataService("LogDataService");
	}
	public static PersonnelDataService getPersonnelDataService(){
		return (PersonnelDataService) DataServiceFactory.getDataService("PersonnelDataService");
	}
	public static TransportCommodityDataService getTransportCommodityDataService(){
		return (TransportCommodityDataService) DataServiceFactory.getDataService("TransportCommodityDataService");
	}
	public static TransportListDataService getTransportListDataService(){
		return (TransportListDataService) DataServiceFactory.getDataService("TransportListDataService");
	}
	public static TransportToolDataService getTransportToolDataService(){
		return (TransportToolDataService) DataServiceFactory.getDataService("TransportToolDataService");
	}
	public static UserDataService getUserDataService(){
		return (UserDataService) DataServiceFactory.getDataService("UserDataService");
	}
	public static WarehouseCheckinDataService getWarehouseCheckinDataService(){
		return (WarehouseCheckinDataService) DataServiceFactory.getDataService("WarehouseCheckinDataService");
	}
	public static WarehouseCheckoutDataService getWarehouseCheckoutDataService(){
		return (WarehouseCheckoutDataService) DataServiceFactory.getDataService("WarehouseCheckoutDataService");
	}
	public static WarehouseDataService getWarehouseCheckDataService(){
		return (WarehouseDataService) DataServiceFactory.getDataService("WarehouseCheckDataService");
	}
}