package edu.nju.lms.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.DispatchPO;
import edu.nju.lms.PO.LoadPO;
import edu.nju.lms.PO.ReceivePO;
import edu.nju.lms.PO.SendPO;
import edu.nju.lms.data.ResultMessage;

public interface TransportListDataService extends Remote{
	
	public ResultMessage addSend(SendPO send) throws RemoteException;
	public ResultMessage deleteSend(String id) throws RemoteException;
	public ResultMessage addLoad(LoadPO load) throws RemoteException;
	public ResultMessage deleteLoad(String id) throws RemoteException;
	public ResultMessage addArrival(ArrivalPO arrival) throws RemoteException;
	public ResultMessage deleteArrival(String id) throws RemoteException;
	public ResultMessage addDispatch(DispatchPO Recieve) throws RemoteException;
	public ResultMessage deleteDispatch(String id) throws RemoteException;
	public ResultMessage addReceive(ReceivePO recieve) throws RemoteException;
	public ResultMessage deleteReceive(String id) throws RemoteException;
	
}
