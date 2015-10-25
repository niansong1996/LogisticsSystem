package edu.nju.lms.businessLogicService.impl;

import edu.nju.lms.VO.DriverVO;
import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogicService.TransManageblService;
import edu.nju.lms.data.ResultMessage;

public class TransManageblImply implements TransManageblService{

	public VehicleVO addVehicle(VehicleVO plateNum) {
		return new VehicleVO("0000000000", "苏F216FU", 10);
	}

	public ResultMessage saveVehicleInfor(VehicleVO vehicleInfor) {
		return new ResultMessage(true, "");
	}

	public ResultMessage deleteVehicle(String vehicleNum) {
		return new ResultMessage(true, "");
	}

	public ResultMessage updateVehicle(VehicleVO modified) {
		return new ResultMessage(true, "");
	}

	public VehicleVO findVehicle(String vehicleNum) {
		return new VehicleVO("0000000000", "苏F216FU", 10);
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

}
