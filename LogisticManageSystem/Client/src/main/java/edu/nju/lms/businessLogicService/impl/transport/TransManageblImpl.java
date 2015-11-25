package edu.nju.lms.businessLogicService.impl.transport;

import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.VO.DriverVO;
import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.TransportToolDataService;

public class TransManageblImpl{

	private DepartmentController department;
	TransportToolDataService service;
	private static int basicCarNum=0;
	private static int basicDriverNum=0;
	
	public TransManageblImpl(TransportToolDataService tool){
		this.service=tool;
	}
	
	public VehicleVO addVehicle(VehicleVO vehicle) {
		VehicleVO car=vehicle;
		car.setVehicleNum(createCarNum(vehicle.getBusinessHallNum()));
		return car;
	}

	public ResultMessage saveVehicleInfor(VehicleVO vehicleInfor) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		return new ResultMessage(true, "");
	}

	public ResultMessage deleteVehicle(String vehicleNum) {
		return new ResultMessage(true, "");
	}

	public ResultMessage updateVehicle(VehicleVO modified) {
		return new ResultMessage(true, "");
	}

	public VehicleVO findVehicle(String vehicleNum) {
		
	}

	public DriverVO addDriver(DriverVO driverNum) {
		return new DriverVO("020202", "niansong", "1996/01/02", "320000199601020000", "12312341234", 0, "20");
	}

	public ResultMessage saveDriverInfor(DriverVO driverInfor) {
		return new ResultMessage(true, "");
	}

	public ResultMessage deleteDriver(String driverNum) {
		return new ResultMessage(true, "");
	}

	public ResultMessage updateDriver(DriverVO modified) {
		return new ResultMessage(true, "");
	}

	public DriverVO findDriver(String vehicleNum) {
		return new DriverVO("020202", "niansong", "1996/01/02", "320000199601020000", "12312341234", 0, "20");
	}

	public String createCarNum(String businessNum){
		String temp=String.valueOf(basicCarNum);
		while(temp.length()<3){
			temp="0"+temp;
		}
		String result=businessNum+temp;
		basicCarNum++;
		return result;
	}
	public String createDriverNum(String businessNum){
		String temp=String.valueOf(basicDriverNum);
		while(temp.length()<3){
			temp="0"+temp;
		}
		String result=businessNum+temp;
		basicDriverNum++;
		return result;
	}
//	public ResultMessage check(String businessNum){
//		ResultMessage result=new ResultMessage(true,"");
//		DepartmentVO depart=department.getDepartInfo(businessNum);
//		if(depart==null){
//			result.setSuccess(false);
//			result.setErrorMessage("未找到该机构！");
//		}
//		return result;
//	}
}
