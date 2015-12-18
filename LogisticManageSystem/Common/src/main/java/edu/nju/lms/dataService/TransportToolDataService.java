package edu.nju.lms.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.DriverPO;
import edu.nju.lms.PO.VehiclePO;
import edu.nju.lms.data.ResultMessage;

public interface TransportToolDataService extends Remote{
	
	public ResultMessage addVehicle(VehiclePO vehicle) throws RemoteException;
	public VehiclePO findVehicle(String id) throws RemoteException;
	public ResultMessage deleteVehicle(String id) throws RemoteException;
	public ResultMessage updateVehicle(VehiclePO vehicle) throws RemoteException;
	public ArrayList<VehiclePO> showAllVihicle() throws RemoteException;
	
	public ResultMessage addDriver(DriverPO driver) throws RemoteException;
	public DriverPO findDriver(String id) throws RemoteException;
	public ResultMessage deleteDriver(String id) throws RemoteException;
	public ResultMessage updateDriver(DriverPO driver) throws RemoteException;
	public ArrayList<DriverPO> showAllDrivers() throws RemoteException;
}
