package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;

import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.DispatchPO;
import edu.nju.lms.PO.LoadPO;
import edu.nju.lms.PO.ReceivePO;
import edu.nju.lms.PO.SendPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.TransportListService;

public class TransportListDataImpl {

	public ResultMessage addSend(SendPO send) throws RemoteException {
		return new ResultMessage(true, "");
	}

	public ResultMessage deleteSend(String id) throws RemoteException {
		return new ResultMessage(true, "");
	}

	public ResultMessage addLoad(LoadPO load) throws RemoteException {
		return new ResultMessage(true, "");
	}

	public ResultMessage deleteLoad(String id) throws RemoteException {
		return new ResultMessage(true, "");
	}

	public ResultMessage addArrival(ArrivalPO arrival) throws RemoteException {
		return new ResultMessage(true, "");
	}

	public ResultMessage deleteArrival(String id) throws RemoteException {
		return new ResultMessage(true, "");
	}

	public ResultMessage addDispatch(DispatchPO Recieve) throws RemoteException {
		return new ResultMessage(true, "");
	}

	public ResultMessage deleteDispatch(String id) throws RemoteException {
		return new ResultMessage(true, "");
	}

	public ResultMessage addRecieve(ReceivePO recieve) throws RemoteException {
		return new ResultMessage(true, "");
	}

	public ResultMessage deleteRecieve(String id) throws RemoteException {
		return new ResultMessage(true, "");
	}

}
