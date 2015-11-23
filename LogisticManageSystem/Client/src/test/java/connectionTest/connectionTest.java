package connectionTest;

import java.rmi.Naming;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.UserPO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.dataService.FinanceAccountDataService;
import edu.nju.lms.dataService.UserDataService;

public class connectionTest {
	public static AccountPO accountPo1 = new AccountPO("6225887941959874",1212343.5);
	public static AccountPO accountPo2 = new AccountPO("6225887941959874",33.5);
	public static void main(String[] args){    
	      try{    
	         FinanceAccountDataService financeAccountData = (FinanceAccountDataService) Naming.lookup("//127.0.0.1:1099/FinanceAccountDataService");    
	             
	         //如果要从另一台启动了RMI注册服务的机器上查找hello实例    
	         //HelloInterface hello = (HelloInterface)Naming.lookup("//192.168.1.105:1099/Hello");    
//	            financeAccountData.addAccount(accountPo1);
	            financeAccountData.updateAccount(accountPo2);
	      }    
	      catch (Exception e){    
	         System.out.println("HelloClient exception: " + e);    
	      }    
	   }    
	
}
