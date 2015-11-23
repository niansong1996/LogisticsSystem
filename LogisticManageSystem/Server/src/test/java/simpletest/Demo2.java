package simpletest;

import java.util.ArrayList;

import edu.nju.lms.PO.AccountPO;
import edu.nju.lms.PO.ArrivalPO;
import edu.nju.lms.PO.CheckinPO;
import edu.nju.lms.PO.CheckoutPO;
import edu.nju.lms.PO.CityPO;
import edu.nju.lms.PO.DriverPO;
import edu.nju.lms.sql.POGenerator;

public class Demo2 {
	public static void main(String[] args) {
		ArrayList<Double> distance = new ArrayList<Double>();
		distance.add(Math.random());
		distance.add(Math.random());
		distance.add(Math.random());
		ArrayList<String> businessNums = new ArrayList<String>();
		businessNums.add("oifnwei");
		businessNums.add("ewewi");
		businessNums.add("29h4g");
		System.out.println(businessNums.toString());
		System.out.println(distance.toString());
		
		CityPO cityPo1 = new CityPO("0250","Nanjing",businessNums.toString(),distance.toString());
		CityPO cityPo2 = new CityPO("0210","Shanghai",businessNums.toString(),distance.toString());
		
		return;
		
		
	}

}
