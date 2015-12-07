package edu.nju.lms.businessLogic;

import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;

public class BusinessLogicFactory {
	private static DepartmentController departmentController;
	private static FinanceController financeController;
	private static ListController listController;
	private static LogController logController;
	private static PersonnelController personnelController;
	private static TransportController transportController;
	private static UserController userController;
	private static WarehouseController warehouseController;
	
	public static DepartmentController createDepartmentController(){
		if(departmentController!=null) return departmentController;
		logController = createLogController();
		departmentController = new DepartmentController();
		return departmentController;
	}
	public static DepartmentController getDepartmentController() throws NoBusinessLogicException{
		if(departmentController!=null) return departmentController;
		else {
			System.err.println("departmentController not initialized");
			throw new NoBusinessLogicException();
		}
	}
	
	public static FinanceController createFinanceController(){
		if(financeController!=null) return financeController;
		logController = createLogController();
		listController = createListController();
		personnelController = createPersonnelController();
		transportController = createTransportController();
		warehouseController = createWarehouseController();
		financeController = new FinanceController();
		return financeController;
	}
	public static FinanceController getFinanceController() throws NoBusinessLogicException{
		if(financeController!=null) return financeController;
		else {
			System.err.println("financeController not initialized");
			throw new NoBusinessLogicException();
		}
	}
	
	public static ListController createListController(){
		if(listController!=null) return listController;
		logController = createLogController();
		listController = new ListController();
		return listController;
	}
	public static ListController getListController() throws NoBusinessLogicException{
		if(listController!=null) return listController;
		else{
			System.err.println("listController not initialized");
			throw new NoBusinessLogicException();
		}
	}
	
	public static LogController createLogController(){
		if(logController!=null) return logController;
		logController = new LogController();
		return logController;
	}
	public static LogController getLogController() throws NoBusinessLogicException{
		if(logController!=null) return logController;
		else{
			System.err.println("logController not initialized");
			throw new NoBusinessLogicException();
		}
	}
	
	public static PersonnelController createPersonnelController(){
		if(personnelController!=null) return personnelController;
		logController = createLogController();
		personnelController = new PersonnelController();
		return personnelController;
	}
	public static PersonnelController getPersonnelController() throws NoBusinessLogicException{
		if(personnelController!=null) return personnelController;
		else{
			System.err.println("personnelController not initialized");
			throw new NoBusinessLogicException();
		}
	}
	
	public static TransportController createTransportController(){
		if(transportController!=null) return transportController;
		logController = createLogController();
		listController = createListController();
		personnelController = createPersonnelController();
		departmentController = createDepartmentController();
		transportController = new TransportController();
		return transportController;
	}
	public static TransportController getTransportController() throws NoBusinessLogicException{
		if(transportController!=null) return transportController;
		else {
			System.err.println("transportController not initialized");
			throw new NoBusinessLogicException();
		}
	}
	
	public static UserController createUserController(){
		if(userController!=null) return userController;
		logController = createLogController();
		userController = new UserController();
		return userController;
	}
	public static UserController getUserController() throws NoBusinessLogicException{
		if(userController!=null) return userController;
		else {
			System.err.println("userController not initialized");
			throw new NoBusinessLogicException();
		}
	}
	
	public static WarehouseController createWarehouseController(){
		if(warehouseController!=null) return warehouseController;
		listController = createListController();
		warehouseController = new WarehouseController();
		return warehouseController;
	}
	public static WarehouseController getWarehouseController() throws NoBusinessLogicException{
		if(warehouseController!=null) return warehouseController;
		else {
			System.err.println("warehouseController not initialized");
			throw new NoBusinessLogicException();
		}
	}
}
