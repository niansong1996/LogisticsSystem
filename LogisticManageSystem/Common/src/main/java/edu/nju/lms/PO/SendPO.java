package edu.nju.lms.PO;

import java.util.ArrayList;

import edu.nju.lms.data.ListState;
import edu.nju.lms.data.PackingType;
import edu.nju.lms.data.TransportMode;

/**
 *@author tj
 *@date ����5:12:31
 */
public class SendPO extends ListPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7648258119493841934L;
	//the express's number
	private String expressNum;
	//base information of sender and receiver
	private ArrayList<String> baseInfor;
	public static enum SendBaseInfor{
		//sender's information
		SENDERNAME,SENDERADDRESS,SENDERCOMPANY,SENDERPHONE,SENDERTELE,
		//receivers information
		RECEIVERNAME,RECEIVERADDRESS,RECEIVERCOMPANY,RECEIVERPHONE,RECEIVERTELE
	}
	
	/**
	 * goods' information
	 */
	private int initialNum;
	/**
	 * kg
	 */
	private double weight; 
	/**
	 * m3
	 */
	private double volume;
	private String goodsName;
	
	private PackingType packingType;
	//transporting mode
	private TransportMode mode;
	/**
	 * price and days will needed
	 */
	private double price;
	private double time;
	
	//constructor for reflection
	public SendPO(String expressNum,String state,String id,String baseInfor,String initialNum, String weight, String volume, String goodsName,
			String packingType, String mode, String price, String time) {
		super(id,ListState.valueOf(state));
		this.expressNum = expressNum;
		this.baseInfor = new ArrayList<String>();
		String baseInforTmp = baseInfor.replace("[", "").replace("]", "");
		if(!baseInforTmp.equals("")){
		String baseInforTmpArray[] = baseInforTmp.split(", ");
		for(String tmp : baseInforTmpArray) this.baseInfor.add(tmp);
		}
		this.initialNum = Integer.parseInt(initialNum);
		this.weight = Double.parseDouble(weight);
		this.volume = Double.parseDouble(volume);
		this.goodsName = goodsName;
		this.packingType = PackingType.valueOf(packingType);
		this.mode = TransportMode.valueOf(mode);
		this.price = Double.parseDouble(price);
		this.time = Double.parseDouble(time);
	}
	
	
	//construct function
	public SendPO(String expressNum,ListState state,String id,ArrayList<String> baseInfor,int initialNum, double weight, double volume, String goodsName,
			PackingType packingType, TransportMode mode, double price, double time) {
		super(id,state);
		this.expressNum = expressNum;
		this.baseInfor = baseInfor;
		this.initialNum = initialNum;
		this.weight = weight;
		this.volume = volume;
		this.goodsName = goodsName;
		this.packingType = packingType;
		this.mode = mode;
		this.price = price;
		this.time = time;
	}
	public String getExpressNum() {
		return expressNum;
	}
	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}
	//override to input more conveniently
	public SendPO(String expressNum,ListState state, String id,ArrayList<String> baseInfor,double weight, double volume, String goodsName, double price, double time) {
		super(id,state);
		this.expressNum = expressNum;
		this.baseInfor=baseInfor;
		this.initialNum = 1;
		this.weight = weight;
		this.volume = volume;
		this.goodsName = goodsName;
		this.packingType = PackingType.BAG ;
		this.mode = TransportMode.NORMAL;
		this.price = price;
		this.time = time;
	}
	public SendPO(String expressNum,ListState state,String id,ArrayList<String> baseInfor, double weight, double volume, String goodsName,
			PackingType packingType, TransportMode mode, double price, double time) {
		super(id,state);
		this.expressNum = expressNum;
		this.baseInfor=baseInfor;
		this.initialNum = 1;
		this.weight = weight;
		this.volume = volume;
		this.goodsName = goodsName;
		this.packingType = packingType;
		this.mode = mode;
		this.price = price;
		this.time = time;
	}
	public SendPO(String expressNum,ListState state,String id,ArrayList<String> baseInfor,int initialNum, double weight, double volume, String goodsName, TransportMode mode, double price, double time) {
		super(id,state);
		this.expressNum = expressNum;
		this.baseInfor=baseInfor;
		this.initialNum = initialNum;
		this.weight = weight;
		this.volume = volume;
		this.goodsName = goodsName;
		this.packingType = PackingType.BAG;
		this.mode = mode;
		this.price = price;
		this.time = time;
	}
	public SendPO(String expressNum,ListState state,String id,ArrayList<String> baseInfor,int initialNum, double weight, double volume, String goodsName,
			PackingType packingType,  double price, double time) {
		super(id,state);
		this.baseInfor=baseInfor;
		this.initialNum = initialNum;
		this.weight = weight;
		this.volume = volume;
		this.goodsName = goodsName;
		this.packingType = packingType;
		this.mode = TransportMode.NORMAL;
		this.price = price;
		this.time = time;
	}
	//getters and setters
	public int getInitialNum() {
		return initialNum;
	}
	public void setInitialNum(int initialNum) {
		this.initialNum = initialNum;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public PackingType getPackingType() {
		return packingType;
	}
	public void setPackingType(PackingType packingType) {
		this.packingType = packingType;
	}
	public TransportMode getMode() {
		return mode;
	}
	public void setMode(TransportMode mode) {
		this.mode = mode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	
}
