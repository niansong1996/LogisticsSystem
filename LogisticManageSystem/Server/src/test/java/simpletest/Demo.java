package simpletest;

import java.rmi.RemoteException;

import edu.nju.lms.PO.UserPO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.dataService.impl.UserDataImpl;
import edu.nju.lms.sql.JDBC;
import edu.nju.lms.sql.POGenerator;

public class Demo {
	public static void main(String[] args){
		UserPO userPo1 = new UserPO("1234567899","999",PersonType.MANAGER);
		UserPO userPo2 = new UserPO("7364534263","876567",PersonType.ADMINISTRATOR);
		UserPO userPo3 = null;
		JDBC jdbc = new JDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		UserDataImpl userData = null;
		try {
			userData = new UserDataImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			userData.addUser(userPo2);
			userData.addUser(userPo1);
			System.out.println(userData.getAllUser().size());
			for(UserPO userPo4 : userData.getAllUser()){
				//			userPo3 = userData.findUser(userPo2.getUserName());
				System.out.println(userPo4.getUserName()+"  "+userPo3.getPassword()+"  "+userPo3.getPower());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
