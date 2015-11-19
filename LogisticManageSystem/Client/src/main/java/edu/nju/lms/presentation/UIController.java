package edu.nju.lms.presentation;

import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;

public class UIController {
	private MainFrame frame;
	private DepartmentController departmentController;
	private FinanceController financeController;
	private ListController listController;
	private LogController logController;
	private TransportController transportController;
	private UserController userController;
	private WarehouseController warehouseController;
	public UIController() {
		userController = new UserController();
		frame = new MainFrame();
	}
	public void changeTo(String panel){
		frame.changeTo(panel,this);
	}
	public MainFrame getFrame() {
		return frame;
	}
	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}
	public DepartmentController getDepartmentController() {
		return departmentController;
	}
	public void setDepartmentController(DepartmentController departmentController) {
		this.departmentController = departmentController;
	}
	public FinanceController getFinanceController() {
		return financeController;
	}
	public void setFinanceController(FinanceController financeController) {
		this.financeController = financeController;
	}
	public ListController getListController() {
		return listController;
	}
	public void setListController(ListController listController) {
		this.listController = listController;
	}
	public LogController getLogController() {
		return logController;
	}
	public void setLogController(LogController logController) {
		this.logController = logController;
	}
	public TransportController getTransportController() {
		return transportController;
	}
	public void setTransportController(TransportController transportController) {
		this.transportController = transportController;
	}
	public UserController getUserController() {
		return userController;
	}
	public void setUserController(UserController userController) {
		this.userController = userController;
	}
	public WarehouseController getWarehouseController() {
		return warehouseController;
	}
	public void setWarehouseController(WarehouseController warehouseController) {
		this.warehouseController = warehouseController;
	}
	public void createDepartmentController(){
		departmentController = new DepartmentController();
	}
}
