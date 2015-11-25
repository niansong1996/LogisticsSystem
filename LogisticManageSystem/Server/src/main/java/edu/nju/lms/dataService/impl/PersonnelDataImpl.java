package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.lms.PO.PersonnelPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.PersonnelDataService;

/**
 * @author oppalu
 * 2015/11/18
 *
 */
public class PersonnelDataImpl extends UnicastRemoteObject implements PersonnelDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1278885707116401114L;

	public PersonnelDataImpl() throws RemoteException {
	}

	public ResultMessage addPersonnel(PersonnelPO personnel) throws RemoteException {
		if(findPersonnel(personnel.getId())==null){
			JDBC.ExecuteData(POGenerator.generateInsertOp(personnel, personnel.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"The personnel already exists!");
		}
	}

	public PersonnelPO findPersonnel(String id) throws RemoteException {
		PersonnelPO personnel = null;
		ResultSet result = JDBC.ExecuteQuery("select * from personnelpo where id = "+id);
		try{
		if(!result.wasNull())
			personnel = (PersonnelPO)POGenerator.generateObject(result, PersonnelPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return personnel;
	}
	
	public ArrayList<PersonnelPO> ambiFindPersonnel(String id) throws RemoteException {
		ArrayList<PersonnelPO> list = new ArrayList<PersonnelPO>();
		ResultSet result = JDBC.ExecuteQuery("select * from personnelpo where id like \"%"+id+"%\";");
		try{
		if(!result.wasNull())
			POGenerator.generateMultiObject(list,result, PersonnelPO.class.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		};
		return list;
	}

	public ResultMessage deletePersonnel(String id) throws RemoteException {
		PersonnelPO personnel = findPersonnel(id);
		if(!(personnel==null)){
			JDBC.ExecuteData("delete from personnelpo where id = "+id+";");
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the personnel!");
		}
	}

	public ResultMessage updatePersonnel(PersonnelPO personnel) throws RemoteException {
		PersonnelPO tempPersonnel = findPersonnel(personnel.getId());
		if(!(tempPersonnel==null)){
			JDBC.ExecuteData(POGenerator.generateUpdateOp(personnel, personnel.getClass().getName()));
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the personnel!");
		}
	}

}
