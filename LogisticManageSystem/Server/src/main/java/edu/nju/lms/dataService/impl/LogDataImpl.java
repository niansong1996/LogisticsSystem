package edu.nju.lms.dataService.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.OperationPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.LogDataService;
/**
 * @author oppalu
 * @date 2015/11/19
 *
 */
public class LogDataImpl implements LogDataService{

	/**
	 * add a log info
	 * write it into the txt file
	 */
	public ResultMessage addOperation(OperationPO operation) throws RemoteException {
		try {
			File file=new File("log.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw=new FileWriter(file,true);
			
			fw.write(operation.getTime()+" "+operation.getUser()+" "+operation.getExplain());
			fw.write("\r\n");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResultMessage(true,null);
	}

	/**
	 * find the info of log in valid time
	 */
	public ArrayList<OperationPO> findOperation(Calendar begin, Calendar end) throws RemoteException {
		ArrayList<OperationPO> result=new ArrayList<OperationPO>();
		String get="";
		OperationPO op;
		String[] temp;
		Calendar c=Calendar.getInstance();
		try {
			File file=new File("log.txt");
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			while((get=br.readLine())!=null){
				temp=get.split(" ");
				String[] temp1=temp[0].split("/");
				int year=Integer.parseInt(temp1[0]);
				int month=Integer.parseInt(temp1[1]);
				int day=Integer.parseInt(temp1[2]);
				c.set(year, month, day);
				if(begin.before(c)&&end.after(c)){
					op=new OperationPO(temp[0],temp[1],temp[2]);
					result.add(op);
				}
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
