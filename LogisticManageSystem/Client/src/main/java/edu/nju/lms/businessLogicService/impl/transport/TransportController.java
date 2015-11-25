package edu.nju.lms.businessLogicService.impl.transport;

import java.rmi.Naming;

import edu.nju.lms.VO.ArrivalVO;
import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.VO.DriverVO;
import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.VO.TransportVO;
import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogicService.TransManageblService;
import edu.nju.lms.businessLogicService.TransProcessblService;
import edu.nju.lms.businessLogicService.impl.department.DepartmentblImpl;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.data.ArrivalState;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.DepartmentDataService;
import edu.nju.lms.dataService.TransportCommdityDataService;
import edu.nju.lms.dataService.TransportListDataService;
import edu.nju.lms.dataService.TransportToolDataService;

public class TransportController implements TransManageblService,TransProcessblService{
	
	TransportToolDataService toolData;
	TransportListDataService listData;
	
	TransManageblImpl manage;
	TransProcessblImpl process;
	
	String logId;
	
	public TransportController(){
		try {
			toolData=(TransportToolDataService) Naming.lookup("//127.0.0.1:1099/TransportToolDataService");
			manage=new TransManageblImpl(toolData);
		} catch (Exception e) {
			System.out.println("网络未连接！");
			System.exit(0);
		} 
	}
	public TransportController(String id){
		this.logId=id;
	}
	
	public OrderInforVO checkOrderInfor(String orderNum) {
		return process.checkOrderInfor(orderNum);
	}

	public SendVO createSendList(SendVO baseMessage) {
		return process.createSendList(baseMessage);
	}

	public ResultMessage saveSendList(SendVO sendList) {
		return process.saveSendList(sendList);
	}

	public LoadVO createLoadList(LoadVO baseMessage) {
		return process.createLoadList(baseMessage);
	}

	public ResultMessage saveLoadList(LoadVO loadList) {
		return process.saveLoadList(loadList);
	}

	public ArrivalVO createArrivalList(ArrivalState state, String orderNum) {
		return process.createArrivalList(state, orderNum);
	}

	public ResultMessage saveArrivalList(ArrivalVO arrivalList) {
		return process.saveArrivalList(arrivalList);
	}

	public DispatchVO createDispatchList(String courierNum, String dispatchperson) {
		return process.createDispatchList(courierNum, dispatchperson);
	}

	public ResultMessage saveDispatchList(DispatchVO dipatchList) {
		return process.saveDispatchList(dipatchList);
	}

	public ResultMessage saveTransportList(TransportVO transportInfor) {
		return process.saveTransportList(transportInfor);
	}

	public VehicleVO addVehicle(VehicleVO plateNum) {
		return manage.addVehicle(plateNum);
	}

	public ResultMessage saveVehicleInfor(VehicleVO vehicleInfor) {
		return manage.saveVehicleInfor(vehicleInfor);
	}

	public ResultMessage deleteVehicle(String vehicleNum) {
		return manage.deleteVehicle(vehicleNum);
	}

	public ResultMessage updateVehicle(VehicleVO modified) {
		return manage.updateVehicle(modified);
	}

	public VehicleVO findVehicle(String vehicleNum) {
		return manage.findVehicle(vehicleNum);
	}

	public DriverVO addDriver(DriverVO driver) {
		return manage.addDriver(driver);
	}

	public ResultMessage saveDriverInfor(DriverVO driver) {
		return manage.saveDriverInfor(driver);
	}

	public ResultMessage deleteDriver(String id) {
		return manage.deleteDriver(id);
	}

	public ResultMessage updateDriver(DriverVO driver) {
		return manage.updateDriver(driver);
	}

	public DriverVO findDriver(String id) {
		return manage.findDriver(id);
	}
}
