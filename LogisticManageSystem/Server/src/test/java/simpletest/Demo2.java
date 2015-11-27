package simpletest;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.CheckinPO;
import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DriverPO;
import edu.nju.lms.PO.PaymentPO;
import edu.nju.lms.PO.UserPO;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.PaymentType;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.data.utility.POGenerator;
import edu.nju.lms.dataService.FinancePaymentDataService;
import edu.nju.lms.dataService.impl.FinancePaymentDataImpl;

public class Demo2 {
	public static FinancePaymentDataService financePaymentData;
	public static void main(String[] args) throws RemoteException {
		financePaymentData = new FinancePaymentDataImpl();
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		AccountPO accountPo1 = new AccountPO("6225887941959874",1212343.5);
		AccountPO accountPo2 = new AccountPO("6836474938271738",8736482.2);
		PaymentPO paymentPo1 = new PaymentPO("8736473827",ListState.WAITING,PaymentType.SALARY,cal1,accountPo1.getName(),23452.2);
		PaymentPO paymentPo2 = new PaymentPO("8394837820",ListState.WAITING,PaymentType.FREIGHT,cal2,accountPo2.getName(),83732.2);
		PaymentPO paymentPo3 = new PaymentPO("8394837820",ListState.WAITING,PaymentType.FREIGHT,cal2,accountPo2.getName(),83732.2);
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table paymentpo");
		try {
			financePaymentData.addPayment(paymentPo1);
			financePaymentData.addPayment(paymentPo2);
			for(PaymentPO p :financePaymentData.findPayment(cal1)){
				System.out.println(p.getId());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
		
		
	}

}
