package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.DispatchPO;
import edu.nju.lms.PO.LoadPO;
import edu.nju.lms.PO.ReceivePO;
import edu.nju.lms.PO.SendPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.TransportListDataService;

public class TransportListDataImpl implements TransportListDataService {
	
	private ArrayList<SendPO> sendList = new ArrayList<SendPO>();
	private ArrayList<LoadPO> loadList = new ArrayList<LoadPO>();
	private ArrayList<ArrivalPO> arrivalList = new ArrayList<ArrivalPO>();
	private ArrayList<DispatchPO> dispatchList = new ArrayList<DispatchPO>();
	private ArrayList<ReceivePO> receiveList = new ArrayList<ReceivePO>();

	public ResultMessage addSend(SendPO send) throws RemoteException {
		if(findSend(send.getId())==null){
			this.sendList.add(send);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The send list already exists!");
		}
	}
	public SendPO findSend(String id) throws RemoteException {
		SendPO result = null;
		Iterator<SendPO> it = sendList.iterator();
		while(it.hasNext()){
			SendPO next = it.next();
			if(next.getId().equals(id)){
				result = next;
				break;
			}
		}
		return result;
	}
	public ResultMessage deleteSend(String id) throws RemoteException {
		SendPO send = findSend(id);
		if(!(send==null)){
			sendList.remove(send);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the send list!");
		}
	}

	public ResultMessage addLoad(LoadPO load) throws RemoteException {
		if(findLoad(load.getId())==null){
			this.loadList.add(load);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The load list already exists!");
		}
	}
	public LoadPO findLoad(String id) throws RemoteException {
		LoadPO result = null;
		Iterator<LoadPO> it = loadList.iterator();
		while(it.hasNext()){
			LoadPO next = it.next();
			if(next.getId().equals(id)){
				result = next;
				break;
			}
		}
		return result;
	}
	public ResultMessage deleteLoad(String id) throws RemoteException {
		LoadPO load = findLoad(id);
		if(!(load==null)){
			loadList.remove(load);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the load list!");
		}
	}

	public ResultMessage addArrival(ArrivalPO arrival) throws RemoteException {
		if(findArrival(arrival.getId())==null){
			this.arrivalList.add(arrival);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The arrival list already exists!");
		}
	}
	public ArrivalPO findArrival(String id) throws RemoteException {
		ArrivalPO result = null;
		Iterator<ArrivalPO> it = arrivalList.iterator();
		while(it.hasNext()){
			ArrivalPO next = it.next();
			if(next.getId().equals(id)){
				result = next;
				break;
			}
		}
		return result;
	}
	public ResultMessage deleteArrival(String id) throws RemoteException {
		ArrivalPO arrival = findArrival(id);
		if(!(arrival==null)){
			arrivalList.remove(arrival);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the arrival list!");
		}
	}

	public ResultMessage addDispatch(DispatchPO dispatch) throws RemoteException {
		if(findDispatch(dispatch.getId())==null){
			this.dispatchList.add(dispatch);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The dispatch list already exists!");
		}
	}
	public DispatchPO findDispatch(String id) throws RemoteException {
		DispatchPO result = null;
		Iterator<DispatchPO> it = dispatchList.iterator();
		while(it.hasNext()){
			DispatchPO next = it.next();
			if(next.getId().equals(id)){
				result = next;
				break;
			}
		}
		return result;
	}
	public ResultMessage deleteDispatch(String id) throws RemoteException {
		DispatchPO dispatch = findDispatch(id);
		if(!(dispatch==null)){
			dispatchList.remove(dispatch);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the dispatch list!");
		}
	}

	public ResultMessage addReceive(ReceivePO receive) throws RemoteException {
		if(findReceive(receive.getId())==null){
			this.receiveList.add(receive);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The receive list already exists!");
		}
	}
	public ReceivePO findReceive(String id) throws RemoteException {
		ReceivePO result = null;
		Iterator<ReceivePO> it = receiveList.iterator();
		while(it.hasNext()){
			ReceivePO next = it.next();
			if(next.getId().equals(id)){
				result = next;
				break;
			}
		}
		return result;
	}
	public ResultMessage deleteReceive(String id) throws RemoteException {
		ReceivePO receive = findReceive(id);
		if(!(receive==null)){
			receiveList.remove(receive);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the receive list!");
		}
	}

}
