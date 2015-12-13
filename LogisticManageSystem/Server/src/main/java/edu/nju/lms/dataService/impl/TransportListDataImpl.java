package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.DispatchPO;
import edu.nju.lms.PO.LoadPO;
import edu.nju.lms.PO.LoadcarPO;
import edu.nju.lms.PO.ReceivePO;
import edu.nju.lms.PO.SendPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.TransportListDataService;

public class TransportListDataImpl extends UnicastRemoteObject implements TransportListDataService{
	public TransportListDataImpl() throws RemoteException {
	}
	private static final long serialVersionUID = 308924668395302280L;

	public ResultMessage addSend(SendPO send) throws RemoteException {
		if(findSend(send.getId())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(send, send.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"The send already exists!");
		}
	}
	public SendPO findSend(String expressNum) throws RemoteException {
		SendPO send = null;
		ResultSet result = JDBC.ExecuteQuery("select * from sendpo where expressNum = \""+expressNum+"\";");
		try{
		if(!result.wasNull())
			send = (SendPO)POGenerator.generateObject(result, SendPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return send;
	}

	public ResultMessage addLoad(LoadPO load) throws RemoteException {
		if(findLoad(load.getId())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(load, load.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"The load already exists!");
		}
	}
	public LoadPO findLoad(String id) throws RemoteException {
		LoadPO load = null;
		ResultSet result = JDBC.ExecuteQuery("select * from loadpo where id = \""+id+"\";");
		try{
		if(!result.wasNull())
			load = (LoadPO)POGenerator.generateObject(result, LoadPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return load;
	}

	public ResultMessage addArrival(ArrivalPO arrival) throws RemoteException {
		if(findArrival(arrival.getId())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(arrival, arrival.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"The arrival already exists!");
		}
	}
	public ArrivalPO findArrival(String id) throws RemoteException {
		ArrivalPO arrival = null;
		ResultSet result = JDBC.ExecuteQuery("select * from arrivalpo where id = \""+id+"\";");
		try{
		if(!result.wasNull())
			arrival = (ArrivalPO)POGenerator.generateObject(result, ArrivalPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return arrival;
	}

	public ResultMessage addDispatch(DispatchPO dispatch) throws RemoteException {
		if(findDispatch(dispatch.getId())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(dispatch, dispatch.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"The dispatch already exists!");
		}
	}
	public DispatchPO findDispatch(String id) throws RemoteException {
		DispatchPO dispatch = null;
		ResultSet result = JDBC.ExecuteQuery("select * from dispatchpo where id = \""+id+"\";");
		try{
		if(!result.wasNull())
			dispatch = (DispatchPO)POGenerator.generateObject(result, DispatchPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return dispatch;
	}

	public ResultMessage addReceive(ReceivePO receive) throws RemoteException {
		if(findReceive(receive.getId())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(receive, receive.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"The receive already exists!");
		}
	}
	public ReceivePO findReceive(String id) throws RemoteException {
		ReceivePO receive = null;
		ResultSet result = JDBC.ExecuteQuery("select * from receivepo where id = \""+id+"\";");
		try{
		if(!result.wasNull())
			receive = (ReceivePO)POGenerator.generateObject(result, ReceivePO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return receive;
	}
	public ArrayList<LoadPO> findUnpaidLoad() throws RemoteException {
		ArrayList<LoadPO> loadList = new ArrayList<LoadPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from loadpo where state = \"PASS\" ;" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(loadList,result, LoadPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return loadList;
	}
	public ResultMessage addLoadCar(LoadcarPO loadcar) throws RemoteException {
		if(findLoadCar(loadcar.getId())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(loadcar, loadcar.getClass().getName()));
			return new ResultMessage(true,"success");
		}
		else{
			return new ResultMessage(false,"The loadcar already exists!");
		}
	}
	public LoadcarPO findLoadCar(String id) throws RemoteException {
		LoadcarPO loadcar = null;
		ResultSet result = JDBC.ExecuteQuery("select * from loadcarpo where id = \""+id+"\";");
		try{
		if(!result.wasNull())
			loadcar = (LoadcarPO)POGenerator.generateObject(result, LoadcarPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return loadcar;
	}
	public ArrayList<LoadcarPO> findUnpaidLoadCar() throws RemoteException {
		ArrayList<LoadcarPO> loadcarList = new ArrayList<LoadcarPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from loadcarpo where state = \"PASS\" ;" );
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(loadcarList,result, LoadcarPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return loadcarList;
	}
	public SendPO findSendById(String id) throws RemoteException {
		SendPO send = null;
		ResultSet result = JDBC.ExecuteQuery("select * from sendpo where id = \""+id+"\";");
		try{
		if(!result.wasNull())
			send = (SendPO)POGenerator.generateObject(result, SendPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return send;
	}

}
