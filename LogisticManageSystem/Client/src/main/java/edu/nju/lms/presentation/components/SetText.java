package edu.nju.lms.presentation.components;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import edu.nju.lms.VO.PriceStrategyVO;
import edu.nju.lms.VO.SalaryStrategyVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;

/**
 *@author tj
 *@date 2015年12月1日
 */
public class SetText {
	public static String mySetText(String type){
		if(type.equals("null")){
			return "";
		}
		FinanceController finance = new FinanceController();
		/**
		 * 对于salaryStrategy,传入的type通过;分割为三部分 如 "salaryStrategy;courier;getBasic"
		 */
		String[] infos = type.split(";");
		String result="";
		if(infos[0].equals("salaryStrategy")){
			SalaryStrategyVO vo = finance.findSalaryStrategy(infos[1]);
			try {
				Class ss = Class.forName("edu.nju.lms.VO.SalaryStrategyVO");
				Method method = ss.getDeclaredMethod(infos[2]);
				if(vo!=null)
				result = method.invoke(vo)+"";
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(infos[0].equals("freightStrategy")){
			PriceStrategyVO vo = finance.findPriceStrategy();
			if(vo!=null)
			return vo.getStandard()+"";
		}
//		SalaryStrategyVO vo;
//		if(type.equals("courierBasic")){
//			vo = finance.findSalaryStrategy("courier");
//			return vo.getBasic()+"";
//		}else if(type.equals("courierPerTime")){
//			vo = finance.findSalaryStrategy("courier");
//			return vo.getPerTime()+"";
//		}else if(type.equals("courierBonus")){
//			vo = finance.findSalaryStrategy("courier");
//			return vo.getBonus()+"";
//		}else if(type.equals("counter_bussinessBasic")){
//			vo = finance.findSalaryStrategy("counter_bussiness");
//			return vo.getBasic()+"";
//		}else if(type.equals("counter_bussinessPerTime")){
//			
//		}
		return result;
	}
}
