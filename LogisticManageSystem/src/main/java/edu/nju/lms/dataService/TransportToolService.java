package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.DriverPO;
import edu.nju.lms.PO.VehiclePO;

public interface TransportToolService {
	
	public boolean addVehicle(VehiclePO vehicle) throws RemoteException;
	public VehiclePO findVehicle(long id) throws RemoteException;
	public boolean deleteVehicle(long id) throws RemoteException;
	public boolean updateVehicle(VehiclePO vehicle) throws RemoteException;
	public boolean addDriver(DriverPO driver) throws RemoteException;
	public DriverPO findDriver(long id) throws RemoteException;
	public boolean deleteDriver(long id) throws RemoteException;
	public boolean updateDriver(DriverPO driver) throws RemoteException;

}
