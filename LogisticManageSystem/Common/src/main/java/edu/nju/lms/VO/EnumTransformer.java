package edu.nju.lms.VO;

import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.LoadType;
import edu.nju.lms.data.PackingType;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.PaymentType;
import edu.nju.lms.data.TransportMode;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class EnumTransformer {
	private static String[] my_types = {"寄件单","收件单","装运单","装车单","收款单","到达单","派件单","入库单",
			"出库单","付款单"};
	private static String[] my_state = {"通过","不通过","等待"};
	private static String[] paymentTypes = {"运费","租金","薪水"};
	private static String[] packTypes = {"快递袋","木箱","纸箱"};
	private static String[] transMode = {"标准快递","次晨快递","经济快递"};
	private static String[] cities = {"南京","上海","广州","北京"};
	private static String[] partitionTypes = {"航运区","铁运区","汽运区","机动区"};
	private static String[] loadTypes = {"飞机","汽车","火车"};
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
	/**
	 * transform the string to PackingType
	 * @param type
	 * @return
	 * @see PackingType
	 */
	public static PackingType str2PackType(String type){
		int index = -1;
		for(int i=0;i<packTypes.length;i++){
			if(type.equals(packTypes[i])){
				index = i;
				break;
			}
		}
		if(index!=-1){
			return PackingType.values()[index];
		}
		return null;
	}
	/**
	 * transform the string to TransportMode
	 * @param mode
	 * @return
	 * @see TransportMode
	 */
	public static TransportMode str2TransMode(String mode){
		int index = -1;
		for(int i=0;i<transMode.length;i++){
			if(mode.equals(transMode[i])){
				index = i;
				break;
			}
		}
		if(index!=-1){
			return TransportMode.values()[index];
		}
		return null;	
	}
	/**
	 * transform the string to PartitionType
	 * @param type
	 * @return
	 * @see PartitionType
	 */
	public static PartitionType str2PartitionType(String type){
		int index = -1;
		for(int i=0;i<partitionTypes.length;i++){
			if(type.equals(partitionTypes[i])){
				index = i;
				break;
			}
		}
		if(index!=-1){
			return PartitionType.values()[index];
		}
		return null;	
	}
	/**
	 * transform the string to LoadType
	 * @param type
	 * @return
	 * @see LoadType
	 */
	public static LoadType str2LoadType(String type){
		int index = -1;
		for(int i=0;i<loadTypes.length;i++){
			if(type.equals(loadTypes[i])){
				index = i;
				break;
			}
		}
		if(index!=-1){
			return LoadType.values()[index];
		}
		return null;	
	}
}
