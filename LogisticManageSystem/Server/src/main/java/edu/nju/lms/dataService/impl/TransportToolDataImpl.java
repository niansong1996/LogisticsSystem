package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.nju.lms.PO.DriverPO;
import edu.nju.lms.PO.VehiclePO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.TransportToolDataService;

public class TransportToolDataImpl extends UnicastRemoteObject implements TransportToolDataService{
	
	public TransportToolDataImpl() throws RemoteException {
	}

	private static final long serialVersionUID = 4734469294067751049L;

	public ResultMessage addVehicle(VehiclePO vehicle) throws RemoteException {
		if(findVehicle(vehicle.getVehicleNum())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(vehicle, vehicle.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The vehicle already exists!");
		}
	}

	public VehiclePO findVehicle(String id) throws RemoteException {
		VehiclePO vehicle = null;
		ResultSet result = JDBC.ExecuteQuery("select * from vehiclepo where vehicleNum = "+id);
		try{
		if(!result.wasNull())
			vehicle = (VehiclePO)POGenerator.generateObject(result, VehiclePO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return vehicle;
	}

	public ResultMessage deleteVehicle(String id) throws RemoteException {
		VehiclePO vehicle = findVehicle(id);
		if(!(vehicle==null)){
			JDBC.ExecuteData("delete from vehiclepo where vehicleNum = "+id+";");
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the vehicle!");
		}
	}

	public ResultMessage updateVehicle(VehiclePO vehicle) throws RemoteException {
		VehiclePO tempVehicle = findVehicle(vehicle.getVehicleNum());
		if(!(tempVehicle==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(vehicle, vehicle.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the vehicle!");
		}
	}

	public ResultMessage addDriver(DriverPO driver) throws RemoteException {
		if(findDriver(driver.getDriverNum())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(driver, driver.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The driver already exists!");
		}
	}

	public DriverPO findDriver(String id) throws RemoteException {
		DriverPO driver = null;
		ResultSet result = JDBC.ExecuteQuery("select * from driverpo where driverNum = "+id);
		try{
		if(!result.wasNull())
			driver = (DriverPO)POGenerator.generateObject(result, DriverPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return driver;
	}

	public ResultMessage deleteDriver(String id) throws RemoteException {
		DriverPO driver = findDriver(id);
		if(!(driver==null)){
			JDBC.ExecuteData("delete from driverpo where driverNum = "+id+";");
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the driver!");
		}
	}

	public ResultMessage updateDriver(DriverPO driver) throws RemoteException {
		DriverPO tempDriver = findDriver(driver.getDriverNum());
		if(!(tempDriver==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(driver, driver.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the driver!");
		}
	}

}
