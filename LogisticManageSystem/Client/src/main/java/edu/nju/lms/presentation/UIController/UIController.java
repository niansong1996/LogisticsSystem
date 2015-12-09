package edu.nju.lms.presentation.UIController;

import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.presentation.config.ConfigReader;
import edu.nju.lms.presentation.config.PanelConfig;
import edu.nju.lms.presentation.frame.MainFrame;
import edu.nju.lms.presentation.frame.MainPanel;

public class UIController {
	/**
	 * frame of client
	 */
	private MainFrame frame;
	/**
	 * all the business logic controller
	 */
	private DepartmentController departmentController;
	private FinanceController financeController;
	private ListController listController;
	private LogController logController;
	private TransportController transportController;
	private UserController userController;
	private WarehouseController warehouseController;
	private PersonnelController personnelController;

	public UIController() {
		initialize();
		frame = new MainFrame();
		ConfigReader r = new ConfigReader();
		PanelConfig panelConfig = r.readPanel("MainPanel");
		MainPanel mainPanel = new MainPanel(panelConfig,this);
		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
		frame.setPanel(mainPanel);
	}

	/**
	 * change to another panel
	 * @param name of panel to change
	 */
	public void changeTo(String panel) {
		frame.changeTo(panel, this);
	}

	/**
	 * initialize controller
	 */
	public void initialize() {
		if(logController==null) {
			logController = BusinessLogicFactory.createLogController();
			userController = BusinessLogicFactory.createUserController();
			listController = BusinessLogicFactory.createListController();
			personnelController = BusinessLogicFactory.createPersonnelController();
			departmentController = BusinessLogicFactory.createDepartmentController();
			warehouseController = BusinessLogicFactory.createWarehouseController();
			transportController = BusinessLogicFactory.createTransportController();
			financeController = BusinessLogicFactory.createFinanceController();
		}
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
