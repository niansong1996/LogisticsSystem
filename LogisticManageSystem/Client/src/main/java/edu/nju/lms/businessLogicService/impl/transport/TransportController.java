package edu.nju.lms.businessLogicService.impl.transport;

import java.rmi.Naming;
import java.util.ArrayList;

import edu.nju.lms.VO.ArrivalVO;
import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.VO.DriverVO;
import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogicService.TransManageblService;
import edu.nju.lms.businessLogicService.TransProcessblService;
import edu.nju.lms.data.ResultMessage;
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
	public ArrayList<OrderInforVO> checkOrderInfor(String orderNum) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage addOrderInfor(OrderInforVO orderInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	public SendVO createSendList(SendVO baseMessage) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage saveSendList(SendVO sendList) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage updateSengdList(SendVO sendList) {
		// TODO Auto-generated method stub
		return null;
	}
	public SendVO findSendList(String expressNum) {
		// TODO Auto-generated method stub
		return null;
	}
	public LoadVO createLoadList(LoadVO baseMessage) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage saveLoadList(LoadVO loadList) {
		// TODO Auto-generated method stub
		return null;
	}
	public LoadVO findLoadList(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrivalVO createArrivalList(ArrivalVO arrivalList) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage saveArrivalList(ArrivalVO arrivalList) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrivalVO findArrivalList(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public DispatchVO createDispatchList(DispatchVO dipatchList) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage saveDispatchList(DispatchVO dipatchList) {
		// TODO Auto-generated method stub
		return null;
	}
	public DispatchVO findDispatchList(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
