package simpletest;

import java.util.ArrayList;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.sql.POGenerator;

public class Demo2 {
	public AccountPO accountPo1 = new AccountPO("6225887941959874",1212343.5);
	public AccountPO accountPo2 = new AccountPO("6836474938271738",8736482.2);
	public static void main(String[] args) {
		if(POGenerator.isContainer(CheckoutPO.class)){
			System.out.println("yes");
		}
		if(POGenerator.isList(ArrivalPO.class)){
			System.out.println("yes");
		}
		

	}

}
