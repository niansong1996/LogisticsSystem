package edu.nju.lms.presentation;

import java.util.ArrayList;

import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.VO.PaymentVO;
import edu.nju.lms.VO.PriceStrategyVO;
import edu.nju.lms.VO.ReceiveVO;
import edu.nju.lms.VO.RentVO;
import edu.nju.lms.VO.SalaryVO;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.PaymentType;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;

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
		logController = BusinessLogicFactory.createLogController();
		userController = BusinessLogicFactory.createUserController();
		listController = BusinessLogicFactory.createListController();
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
		case MANAGER:
		case WAREHOUSE:
		case FINANCIAL_ADVANCED:
		case FINANCIAL_NORMAL:
			warehouseController = BusinessLogicFactory.createWarehouseController();
			personnelController = BusinessLogicFactory.createPersonnelController();
			departmentController = BusinessLogicFactory.createDepartmentController();
			transportController = BusinessLogicFactory.createTransportController();
			financeController = BusinessLogicFactory.createFinanceController();
			break;
		}
		addData();
	}

	public void addData() {
		// PersonnelVO vo = new PersonnelVO("1223014569", "tj", "025458963222",
		// "总经理", 2000, 200, 200);
		// personnelController.addPersonnel(vo);
		// vo = new PersonnelVO("5223014569", "tj", "025458963222", "总经理", 2000,
		// 200, 200);
		// personnelController.addPersonnel(vo);
		// vo = new PersonnelVO("1223014568", "tj", "025458963222", "总经理", 2000,
		// 200, 200);
		// personnelController.addPersonnel(vo);
		// ArrayList<String> s = new ArrayList<String>();
		// ArrayList<Double> x = new ArrayList<Double>();
		// ResultMessage re1 = departmentController.addCity(new
		// CityVO("015","NanJing",s,x));
		// DepartmentVO so = new
		// DepartmentVO(DepartmentType.BUSINESSHALL,"025456","015");
		// ResultMessage re = departmentController.addDepartment(so);
//		SalaryStrategyVO strategy = new SalaryStrategyVO("warehouse", 45, 45, 45);
//		financeController.addSalaryStrategy(strategy);
//		strategy = new SalaryStrategyVO("driver", 45, 45, 45);
//		financeController.addSalaryStrategy(strategy);
//		financeController.addPriceStrategy(100);
//		SendVO vo = new SendVO("1256545696", null,null,2, 2,"hi", 5, 2,null);
//		vo = transportController.createSendList(vo);
//
//		
//		ResultMessage result = transportController.saveSendList(vo);
//		System.out.println(result.getErrorMessage());
		//financeController.addPriceStrategy(100);
//		RentVO vo = new RentVO(null,CommonUtility.getTime(),"212545",20,10);
//		vo = financeController.createRent(vo);
//		ResultMessage me = financeController.saveRent(vo);
//		System.out.println(me.getErrorMessage());
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
