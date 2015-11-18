package edu.nju.lms.dataService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.nju.lms.PO.PersonnelPO;
import edu.nju.lms.PO.UserPO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.PersonnelDataService;

/**
 * @author oppalu
 * 2015/11/18
 *
 */
public class PersonnelDataImpl implements PersonnelDataService{
	
	private ArrayList<PersonnelPO> personnelList=new ArrayList<PersonnelPO>();

	public ResultMessage addPersonnel(PersonnelPO personnel) throws RemoteException {
		if(findPersonnel(personnel.getName())==null){
			personnelList.add(personnel);
			return new ResultMessage(true,null);
		}else{
			return new ResultMessage(false,"The personnel already exists!");
		}
	}

	public PersonnelPO findPersonnel(String id) throws RemoteException {
		PersonnelPO result = null;
		Iterator<PersonnelPO> it = personnelList.iterator();
		while(it.hasNext()){
			PersonnelPO next = it.next();
			if(next.getName().equals(id)){
				result = next;
				break;
			}
		}
		return result;
	}

	public ResultMessage deletePersonnel(String id) throws RemoteException {
		PersonnelPO personnel=findPersonnel(id);
		if(!(personnel==null)){
			personnelList.remove(personnel);
			return new ResultMessage(true,null);
		}else{
			return new ResultMessage(false,"Could not find the personnel!");
		}
	}

	public ResultMessage updatePersonnel(PersonnelPO personnel) throws RemoteException {
		PersonnelPO tempPersonnel=findPersonnel(personnel.getName());
		if(!(tempPersonnel==null)){
			deletePersonnel(tempPersonnel.getName());
			addPersonnel(personnel);
			return new ResultMessage(true,null);
		}
		else{
			return new ResultMessage(false,"Could not find the personnel!");
		}
	}

}
