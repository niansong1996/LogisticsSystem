package edu.nju.lms.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.DispatchPO;
import edu.nju.lms.PO.LoadCarPO;
import edu.nju.lms.PO.LoadPO;
import edu.nju.lms.PO.ReceivePO;
import edu.nju.lms.PO.SendPO;
import edu.nju.lms.data.ResultMessage;

public interface TransportListDataService extends Remote{
	
	public ResultMessage addSend(SendPO send) throws RemoteException;
	public SendPO findSend(String expressNum) throws RemoteException;
	
	public ResultMessage addLoad(LoadPO load) throws RemoteException;
	public LoadPO findLoad(String id) throws RemoteException;
	public ArrayList<LoadPO> findUnpaidLoad() throws RemoteException;
	
	public ResultMessage addLoadCar(LoadCarPO load) throws RemoteException;
	public LoadCarPO findLoadCar(String id) throws RemoteException;
	public ArrayList<LoadCarPO> findAllLoadCar() throws RemoteException;
	
	public ResultMessage addArrival(ArrivalPO arrival) throws RemoteException;
	public ArrivalPO findArrival(String id) throws RemoteException;
	
	public ResultMessage addDispatch(DispatchPO dispatch) throws RemoteException;
	public DispatchPO findDispatch(String id) throws RemoteException;
	
	public ResultMessage addReceive(ReceivePO receive) throws RemoteException;
	public ReceivePO findReceive(String id) throws RemoteException;
}
