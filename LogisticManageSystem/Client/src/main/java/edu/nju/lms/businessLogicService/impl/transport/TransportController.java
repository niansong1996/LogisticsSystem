package edu.nju.lms.businessLogicService.impl.transport;

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
import edu.nju.lms.data.ArrivalState;
import edu.nju.lms.data.ResultMessage;

public class TransportController implements TransManageblService,TransProcessblService{

	TransManageblImpl manage;
	TransProcessblImpl process;
	
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

	public DriverVO addDriver(DriverVO driverNum) {
		return manage.addDriver(driverNum);
	}

	public ResultMessage saveDriverInfor(DriverVO driverInfor) {
		return manage.saveDriverInfor(driverInfor);
	}

	public ResultMessage deleteDriver(String driverNum) {
		return manage.deleteDriver(driverNum);
	}

	public ResultMessage updateDriver(DriverVO modified) {
		return manage.updateDriver(modified);
	}

	public DriverVO findDriver(String vehicleNum) {
		return manage.findDriver(vehicleNum);
	}
}
