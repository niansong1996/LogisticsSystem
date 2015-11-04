package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import edu.nju.lms.PO.DriverPO;
import edu.nju.lms.PO.UserPO;
import edu.nju.lms.PO.VehiclePO;
import edu.nju.lms.data.ResultMessage;

public class TransportToolDataImpl {
	
	private ArrayList<VehiclePO> vehicleList = new ArrayList<VehiclePO>();
	private ArrayList<DriverPO> driverList = new ArrayList<DriverPO>();
	
	public ResultMessage addVehicle(VehiclePO vehicle) throws RemoteException {
		if(findVehicle(vehicle.getVehicleNum())==null){
			this.vehicleList.add(vehicle);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The vehicle already exists!");
		}
	}

	public VehiclePO findVehicle(String id) throws RemoteException {
		VehiclePO result = null;
		Iterator<VehiclePO> it = vehicleList.iterator();
		while(it.hasNext()){
			VehiclePO next = it.next();
			if(next.getPlateNum()==id){
				result = next;
				break;
			}
		}
		return result;
	}

	public ResultMessage deleteVehicle(String id) throws RemoteException {
		VehiclePO vehicle = findVehicle(id);
		if(!(vehicle==null)){
			vehicleList.remove(vehicle);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the vehicle!");
		}
	}

	public ResultMessage updateVehicle(VehiclePO vehicle) throws RemoteException {
		VehiclePO tempVehicle = findVehicle(vehicle.getVehicleNum());
		if(!(tempVehicle==null)){
			tempVehicle = vehicle;
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the vehicle!");
		}
	}

	public ResultMessage addDriver(DriverPO driver) throws RemoteException {
		if(findDriver(driver.getDriverNum())==null){
			this.driverList.add(driver);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The driver already exists!");
		}
	}

	public DriverPO findDriver(String id) throws RemoteException {
		DriverPO result = null;
		Iterator<DriverPO> it = driverList.iterator();
		while(it.hasNext()){
			DriverPO next = it.next();
			if(next.getDriverNum()==id){
				result = next;
				break;
			}
		}
		return result;
	}

	public ResultMessage deleteDriver(String id) throws RemoteException {
		DriverPO driver = findDriver(id);
		if(!(driver==null)){
			driverList.remove(driver);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the driver!");
		}
	}

	public ResultMessage updateDriver(DriverPO driver) throws RemoteException {
		DriverPO tempDriver = findDriver(driver.getDriverNum());
		if(!(tempDriver==null)){
			tempDriver = driver;
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the driver!");
		}
	}

}
