package edu.nju.lms.dataService;

import java.rmi.RemoteException;

import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.DispatchPO;
import edu.nju.lms.PO.LoadPO;
import edu.nju.lms.PO.ReceivePO;
import edu.nju.lms.PO.SendPO;

public interface TransportListService {
	
	public boolean addSend(SendPO send) throws RemoteException;
	public boolean deleteSend(long id) throws RemoteException;
	public boolean addLoad(LoadPO load) throws RemoteException;
	public boolean deleteLoad(long id) throws RemoteException;
	public boolean addArrival(ArrivalPO arrival) throws RemoteException;
	public boolean deleteArrival(long id) throws RemoteException;
	public boolean addDispatch(DispatchPO Recieve) throws RemoteException;
	public boolean deleteDispatch(long id) throws RemoteException;
	public boolean addRecieve(ReceivePO recieve) throws RemoteException;
	public boolean deleteRecieve(long id) throws RemoteException;
	
}
