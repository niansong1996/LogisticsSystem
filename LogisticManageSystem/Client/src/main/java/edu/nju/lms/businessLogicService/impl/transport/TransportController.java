package edu.nju.lms.businessLogicService.impl.transport;

import java.util.ArrayList;

import edu.nju.lms.VO.ArrivalVO;
import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.VO.DriverVO;
import edu.nju.lms.VO.LoadCarVO;
import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.VO.ReceiveVO;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.TransManageblService;
import edu.nju.lms.businessLogicService.TransProcessblService;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.businessLogicService.impl.utility.DataServiceFactory;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.TransportCommodityDataService;
import edu.nju.lms.dataService.TransportListDataService;
import edu.nju.lms.dataService.TransportToolDataService;

public class TransportController implements TransManageblService,TransProcessblService{
	
	TransportToolDataService toolData;
	TransportListDataService listData;
	TransportCommodityDataService commodityData;
	
	TransManageblImpl manage;
	TransProcessblImpl process;
	
	LogController logController;
	ListController listController;
	DepartmentController departmentController;
	PersonnelController personnelController;
	
	public TransportController(){
		try {
			toolData=DataServiceFactory.getTransportToolDataService();
			personnelController=BusinessLogicFactory.getPersonnelController();
			listController = BusinessLogicFactory.getListController();
			departmentController=BusinessLogicFactory.getDepartmentController();
		
			manage=new TransManageblImpl();
			
			listData=DataServiceFactory.getTransportListDataService();
			commodityData=DataServiceFactory.getTransportCommodityDataService();
			
			process=new TransProcessblImpl();
			
			logController=BusinessLogicFactory.getLogController();
		}catch(NoBusinessLogicException e1){
			e1.printStackTrace();
		}
	}
	
	public VehicleVO addVehicle(VehicleVO plateNum) {	
		return manage.addVehicle(listController,plateNum);
	}

	public ResultMessage saveVehicleInfor(VehicleVO vehicleInfor) {
		ResultMessage result=manage.saveVehicleInfor(departmentController,toolData,vehicleInfor);
		
		if(result.isSuccess()){
			logController.addLog("增加车辆"+vehicleInfor.getVehicleNum()+"的信息");
		}
		
		return result;
	}

	public ResultMessage deleteVehicle(String vehicleNum) {
		ResultMessage result=manage.deleteVehicle(toolData,vehicleNum);
		
		if(result.isSuccess()){
			logController.addLog("删除车辆"+vehicleNum+"的信息");
		}
		
		return result;
	}

	public ResultMessage updateVehicle(VehicleVO modified) {
		ResultMessage result=manage.updateVehicle(toolData,modified);
		
		if(result.isSuccess()){
			logController.addLog("更新车辆"+modified.getVehicleNum()+"的信息");
		}
		
		return result;
	}

	public VehicleVO findVehicle(String vehicleNum) {
		VehicleVO result=manage.findVehicle(toolData,vehicleNum);
		logController.addLog("查看车辆"+vehicleNum+"的信息");
		
		return result;
	}

	public DriverVO addDriver(DriverVO driver) {
		return manage.addDriver(listController,driver);
	}

	public ResultMessage saveDriverInfor(DriverVO driver) {
		ResultMessage result=manage.saveDriverInfor(personnelController,departmentController,toolData,driver);
		
		if(result.isSuccess()){
			logController.addLog("增加司机"+driver.getDriverNum()+"的信息");
		}
		
		return result;
	}

	public ResultMessage deleteDriver(String id) {
		ResultMessage result= manage.deleteDriver(personnelController,toolData,id);
		
		if(result.isSuccess()){
			logController.addLog("删除司机"+id+"的信息");
		}
		
		return result;
	}

	public ResultMessage updateDriver(DriverVO driver) {
		ResultMessage result=manage.updateDriver(personnelController,toolData,driver);
		
		if(result.isSuccess()){
			logController.addLog("更新司机"+driver.getDriverNum()+"的信息");
		}
		
		return result;
	}

	public DriverVO findDriver(String id) {
		DriverVO result=manage.findDriver(toolData,id);
		logController.addLog("查看司机"+id+"的信息");
		
		return result;
	}
	public OrderInforVO checkOrderInfor(String orderNum) {
		 OrderInforVO result=process.checkOrderInfor(listData,commodityData,orderNum);
		 logController.addLog("查看快递"+orderNum+"的物流信息");
		 
		 return result;
	}
	
	public SendVO createSendList(SendVO baseMessage) {
		return process.createSendList(listController,departmentController,baseMessage);
	}
	public ResultMessage saveSendList(SendVO sendList) {
		ResultMessage result=process.saveSendList(listData,commodityData,sendList);
		
		if(result.isSuccess()){
			logController.addLog("新建寄件单"+sendList.getId()+"的信息");
		}
		
		return result;
	}
	public SendVO findSendList(String expressNum) {
		SendVO result=process.findSendList(listData,expressNum);
		logController.addLog("查看寄件单"+expressNum+"的信息");
		
		return result;
	}
	public LoadVO createLoadList(LoadVO baseMessage) {
		return process.createLoadList(listController,departmentController,baseMessage);
	}
	public ResultMessage saveLoadList(LoadVO loadList) {
		ResultMessage result=process.saveLoadList(listData,commodityData,loadList);
		
		if(result.isSuccess()){
			logController.addLog("新建装运单"+loadList.getId()+"的信息");
		}
		
		return result;
	}
	public ArrayList<LoadVO> findUnpaidLoad() {
		return process.findUnpaidLoad(listData);
	}
	
	public ArrivalVO createArrivalList(ArrivalVO arrivalList) {
		return process.createArrivalList(listController,arrivalList);
	}
	public ResultMessage saveArrivalList(ArrivalVO arrivalList) {
		ResultMessage result=process.saveArrivalList(listData,commodityData,arrivalList);
		
		if(result.isSuccess()){
			logController.addLog("新建到达单"+arrivalList.getId()+"的信息");
		}
		
		return result;
	}
	public ArrivalVO findArrivalList(String id) {
		ArrivalVO result=process.findArrivalList(listData,id);
		logController.addLog("查看到达单"+id+"的信息");
		
		return result;
	}
	public DispatchVO createDispatchList(DispatchVO dipatchList) {
		return process.createDispatchList(listController,dipatchList);
	}
	public ResultMessage saveDispatchList(DispatchVO dispatchList) {
		ResultMessage result=process.saveDispatchList(listData,commodityData,dispatchList);		
		if(result.isSuccess()){
			logController.addLog("新建派件单"+dispatchList.getId()+"的信息");
		}
		
		return result;
	}
	public DispatchVO findDispatchList(String id) {
		DispatchVO result=process.findDispatchList(listData,id);
		logController.addLog("查看派件单"+id+"的信息");
		
		return result;
	}
	public ReceiveVO createReceiveList(ReceiveVO receiveList) {
		return process.createReceiveList(listController,receiveList);
	}
	public ResultMessage saveReceiveList(ReceiveVO receiveList) {
		ResultMessage result=process.saveReceiveList(listData,commodityData,receiveList);		
		if(result.isSuccess()){
			logController.addLog("新建收件单"+receiveList.getId()+"的信息");
		}
		
		return result;
	}
	public ReceiveVO findReceiveList(String id) {
		ReceiveVO result=process.findReceiveList(listData,id);
		logController.addLog("查看收件单"+id+"的信息");		
		return result;
	}
	public ArrayList<VehicleVO> showAllVehicle() {
		ArrayList<VehicleVO> result=manage.showAllVehicles(toolData);
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		logController.addLog("查看所有车辆的信息");
		return result;
	}

	public LoadCarVO createLoadCarList(LoadCarVO baseMessage) {
		return process.createLoadCarList(listController,baseMessage);
	}

	public ResultMessage saveLoadCarList(LoadCarVO loadCarList) {
		ResultMessage result=process.saveLoadCarList(listData,commodityData,loadCarList);
		if(result.isSuccess()){
			logController.addLog("新建装车单"+loadCarList.getId()+"的信息");
		}
		return result;
	}
	
	public ArrayList<LoadCarVO> findUnpaidLoadCar() {
		return process.findUnpaidLoadCar(listData);
	}

	public LoadVO findLoadList(String id) {
		return process.findLoadList(listData,id);
	}

	public LoadCarVO findLoadCarList(String id) {
		return process.findLoadCarList(listData,id);
	}

	public SendVO findSendListById(String expressNum) {
		return process.findSendListById(listData,expressNum);
	}

	public ArrayList<DriverVO> findAllDrivers() {
		ArrayList<DriverVO> result=manage.findAllDrivers(toolData);
		try {
			logController=BusinessLogicFactory.getLogController();
		} catch (NoBusinessLogicException e) {
		}
		logController.addLog("查看所有司机的信息");
		return result;
	}

	public String getCurrentHallNum(){
		return logController.getLogId().substring(0, 6);
	}
	
	public static void main(String[] args) {
		TransportController t=BusinessLogicFactory.createTransportController();
		SendVO send = t.findSendList("1234567890");
		System.out.println(send.getId());
	}

}
