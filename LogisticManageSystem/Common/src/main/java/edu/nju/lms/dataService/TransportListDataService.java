package edu.nju.lms.dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.DispatchPO;
import edu.nju.lms.PO.LoadPO;
import edu.nju.lms.PO.SendPO;
import edu.nju.lms.data.ResultMessage;

public interface TransportListDataService extends Remote{
	
	public ResultMessage addSend(SendPO send) throws RemoteException;
	public ResultMessage updateSengdList(SendPO sendList);
	public SendPO findSendList(String expressNum);
	
	public ResultMessage addLoad(LoadPO load) throws RemoteException;
	public LoadPO findLoadList(String id) throws RemoteException;
	
	public ResultMessage addArrival(ArrivalPO arrival) throws RemoteException;
	public ArrivalPO findArrival(String id) throws RemoteException;
	
	public ResultMessage addDispatch(DispatchPO Recieve) throws RemoteException;
	public DispatchPO findDispatch(String id) throws RemoteException;
	
}
