package edu.nju.lms.presentation.components;

import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.PaymentType;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class EnumTransformer {
	private static String[] my_types = {"寄件单","收件单","装车单","装运单","收款单","到达单","派件单","入库单",
			"出库单","租金付款单","工资付款单","运费付款单"};
	private static String[] my_state = {"通过","不通过","等待"};
	private static String[] paymentTypes={"运费","租金","薪水"};
	/**
	 * transform the ListType to Chinese
	 * @param type
	 * @return
	 * @see ListType
	 */
	public static String listType2Str(ListType type){
		int t_loc = type.ordinal();
		String t = my_types[t_loc];
		return t;
		
	}
	/**
	 * transform the ListState to Chinese
	 * @param state
	 * @return
	 * @see ListState
	 */
	public static String listState2Str(ListState state){
        int s_loc = state.ordinal();
		String s = my_state[s_loc];
		return s;
	}
	/**
	 * transform the String to ListType
	 * @param type
	 * @return
	 */
	public static ListType str2ListType(String type){
		int index = -1;
		for(int i =0;i<my_types.length;i++){
			if(type.equals(my_types[i])){
				index = i;
				break;
			}
		}
		if(index!=-1){
			return ListType.values()[index];
		}
		return null;
	}
	/**
	 * transform the String to ListState
	 * @param state
	 * @return
	 */
	public static ListState str2ListState(String state){
		int index = -1;
		for(int i =0;i<my_state.length;i++){
			if(state.equals(my_state[i])){
				index = i;
				break;
			}
		}
		if(index!=-1){
			return ListState.values()[index];
		}
		return null;
	}
	/**
	 * transform the PaymentType to String
	 * @param type
	 * @return
	 */
	public static String payment2Str(PaymentType type){
		int loc = type.ordinal();
		return paymentTypes[loc];
	}
}