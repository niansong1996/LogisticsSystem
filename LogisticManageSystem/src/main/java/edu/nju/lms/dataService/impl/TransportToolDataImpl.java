package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.Calendar;

import edu.nju.lms.PO.DriverPO;
import edu.nju.lms.PO.VehiclePO;
import edu.nju.lms.data.ResultMessage;

public class TransportToolDataImpl {

	public ResultMessage addVehicle(VehiclePO vehicle) throws RemoteException {
		return new ResultMessage(true, "");
	}

	public VehiclePO findVehicle(String id) throws RemoteException {
		return new VehiclePO("0000000", "苏F216FU", 10);
	}

	public ResultMessage deleteVehicle(String id) throws RemoteException {
		return new ResultMessage(true, "");
	}

	public ResultMessage updateVehicle(VehiclePO vehicle) throws RemoteException {
		return new ResultMessage(true, "");
	}

	public ResultMessage addDriver(DriverPO driver) throws RemoteException {
		return new ResultMessage(true, "");
	}

	public DriverPO findDriver(String id) throws RemoteException {
		Calendar birth = Calendar.getInstance();
		birth.set(1996, 0, 2);
		Calendar calendar = Calendar.getInstance();
		return new DriverPO("1010100", "niansong",birth , "320000199601020000", "12312341234", 0, calendar);
	}

	public ResultMessage deleteDriver(String id) throws RemoteException {
		return new ResultMessage(true, "");
	}

	public ResultMessage updateDriver(DriverPO driver) throws RemoteException {
		return new ResultMessage(true, "");
	}

}
