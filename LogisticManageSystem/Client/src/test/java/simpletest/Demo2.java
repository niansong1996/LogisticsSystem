package simpletest;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.PO.ListPO;
import edu.nju.lms.PO.ReceiptPO;
import edu.nju.lms.data.ListState;

public class Demo2 {
	static Calendar cal1 = Calendar.getInstance();
	static Calendar cal2 = Calendar.getInstance();
	static ArrayList<String> expressNums1 = new ArrayList<String>();
	static ArrayList<String> expressNums2 = new ArrayList<String>();
	public static ReceiptPO receipt1 = new ReceiptPO("7384736271",ListState.WAITING,cal1,873647.5,"9384736283",expressNums1);
	public static ReceiptPO receipt2 = new ReceiptPO("5374927463",ListState.WAITING,cal1,283626.5,"2326367483",expressNums1);
	
	public static void main(String[] args){
		Demo2 demo = new Demo2();
		demo.f(receipt1,"RECEIPT");
	}
	public void f(ListPO list, String type){
		try {
			Class<?> cls = Class.forName(type.charAt(0)+type.substring(1).toLowerCase()+"PO");
			cls.cast(list);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
