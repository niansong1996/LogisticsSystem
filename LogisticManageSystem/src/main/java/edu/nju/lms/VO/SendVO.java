package edu.nju.lms.VO;

import java.util.ArrayList;

import edu.nju.lms.data.PackingType;
import edu.nju.lms.data.TransportMode;

public class SendVO extends ListVO{

	private long expressNum;
	private TransportMode mode;
	private PackingType packingType;
	
	private int initialNum;
	private double weight; 
	private double volume;
	private String goodsName;
	
	private ArrayList<String> baseInfor;
	public static enum SendBaseInfor{
		//sender's information
		SENDERNAME,SENDERADDRESS,SENDERCOMPANY,SENDERPHONE,SENDERTELE,
		//receivers information
		RECEIVERNAME,RECEIVERADDRESS,RECEIVERCOMPANY,RECEIVERPHONE,RECEIVERTELE
	}

	private double price;
	private int time;
	
	public SendVO(long expressNum,long id,ArrayList<String> baseInfor,int initialNum, double weight, double volume, String goodsName,
			PackingType packingType, TransportMode mode, double price, int time) {
		super(id);
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
	public SendVO(long expressNum, long id,ArrayList<String> baseInfor,double weight, double volume, String goodsName, double price, int time) {
		super(id);
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
	public SendVO(long expressNum,long id,ArrayList<String> baseInfor, double weight, double volume, String goodsName,
			PackingType packingType, TransportMode mode, double price, int time) {
		super(id);
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
	public SendVO(long expressNum,long id,ArrayList<String> baseInfor,int initialNum, double weight, double volume, String goodsName, TransportMode mode, double price, int time) {
		super(id);
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
	public SendVO(long expressNum,long id,ArrayList<String> baseInfor,int initialNum, double weight, double volume, String goodsName,
			PackingType packingType,  double price, int time) {
		super(id);
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
	public long getExpressNum() {
		return expressNum;
	}
	public void setExpressNum(long expressNum) {
		this.expressNum = expressNum;
	}
	public TransportMode getMode() {
		return mode;
	}
	public void setMode(TransportMode mode) {
		this.mode = mode;
	}
	public PackingType getPackingType() {
		return packingType;
	}
	public void setPackingType(PackingType packingType) {
		this.packingType = packingType;
	}
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
	public ArrayList<String> getBaseInfor() {
		return baseInfor;
	}
	public void setBaseInfor(ArrayList<String> baseInfor) {
		this.baseInfor = baseInfor;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	
}
