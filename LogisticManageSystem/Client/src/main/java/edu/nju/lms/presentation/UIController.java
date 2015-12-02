package edu.nju.lms.presentation;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.PersonType;

public class UIController {
	private MainFrame frame;
	private DepartmentController departmentController;
	private FinanceController financeController;
	private ListController listController;
	private LogController logController;
	private TransportController transportController;
	private UserController userController;
	private WarehouseController warehouseController;
	private PersonnelController personnelController;

	public UIController() {
		userController = new UserController();
		logController = new LogController();
		frame = new MainFrame();
	}

	public void changeTo(String panel) {
		frame.changeTo(panel, this);
	}

	/**
	 * initialize controller according to {@link PersonType}
	 * 
	 * @param type
	 */
	public void initialize(PersonType type) {
		switch (type) {
		case ADMINISTRATOR:
			break;
		case COUNTER_INTERMEDIATE:
			warehouseController = BusinessLogicFactory.createWarehouseController();
		case COUNTER_BUSSINESS:
		case COURIER:
			transportController = BusinessLogicFactory.createTransportController();
			break;
		case MANAGER:
			personnelController = BusinessLogicFactory.createPersonnelController();
			departmentController = BusinessLogicFactory.createDepartmentController();
			listController = BusinessLogicFactory.createListController();
		case FINANCIAL_ADVANCED:
		case FINANCIAL_NORMAL:
			financeController = BusinessLogicFactory.createFinanceController();
			break;
		}
		addData();
	}

	public void addData() {
		PersonnelVO vo = new PersonnelVO("122301456999", "tj", "025458963222", "总经理", 2000, 200, 200);
		personnelController.addPersonnel(vo);
		vo = new PersonnelVO("522301456999", "tj", "025458963222", "总经理", 2000, 200, 200);
		personnelController.addPersonnel(vo);
		vo = new PersonnelVO("122301456889", "tj", "025458963222", "总经理", 2000, 200, 200);
		personnelController.addPersonnel(vo);
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

	public void setLogID(String id) {
		logController.setLogId(id);
	}

	public PersonnelController getPersonnelController() {
		return personnelController;
	}

	public void setPersonnelController(PersonnelController personnelController) {
		this.personnelController = personnelController;
	}
}
