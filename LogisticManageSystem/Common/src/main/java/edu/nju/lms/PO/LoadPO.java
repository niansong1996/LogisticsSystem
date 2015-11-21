package edu.nju.lms.PO;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.data.LoadType;

/**
 *@author tj
 *@date ����5:12:31
 */
public class LoadPO extends ListPO {
	//load type
	private LoadType loadType;
	//װ������
	private Calendar loadDate;
	//Ӫҵ�����
	private String businessHallNum;
	//���˱��
	private String motorNum;
	//������ת���Ļ�Ӫҵ��
	private String destiCity;
	private String destiBusinessHall;
	private String vehicleNum;
	private String driverNum;
	/**
	 * the number of the commodities
	 */
	private ArrayList<String> commodityNums;
	
	private double freight;

	public LoadPO(String id,LoadType loadType,Calendar loadDate, String businessHallNum, String motorNum, String destiCity, String destiBusinessHall,
			String vehicleNum, String driverNum, ArrayList<String> commodityNums, double freight) {
		super(id);
		this.loadType = loadType;
		this.loadDate = loadDate;
		this.businessHallNum = businessHallNum;
		this.motorNum = motorNum;
		this.destiCity = destiCity;
		this.destiBusinessHall = destiBusinessHall;
		this.vehicleNum = vehicleNum;
		this.driverNum = driverNum;
		this.commodityNums = commodityNums;
		this.freight = freight;
	}
    public LoadType getLoadType(){
    	return loadType;
    }
    public void setLoadType (LoadType loadType){
    	this.loadType =  loadType;
    }
	public Calendar getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(Calendar loadDate) {
		this.loadDate = loadDate;
	}

	public String getBusinessHallNum() {
		return businessHallNum;
	}

	public void setBusinessHallNum(String businessHallNum) {
		this.businessHallNum = businessHallNum;
	}

	public String getMotorNum() {
		return motorNum;
	}

	public void setMotorNum(String motorNum) {
		this.motorNum = motorNum;
	}

	public String getDestiCity() {
		return destiCity;
	}

	public void setDestiCity(String destiCity) {
		this.destiCity = destiCity;
	}

	public String getDestiBusinessHall() {
		return destiBusinessHall;
	}

	public void setDestiBusinessHall(String destiBusinessHall) {
		this.destiBusinessHall = destiBusinessHall;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getDriverNum() {
		return driverNum;
	}

	public void setDriverNum(String driverNum) {
		this.driverNum = driverNum;
	}

	public ArrayList<String> getCommodityNums() {
		return commodityNums;
	}

	public void setCommodityNums(ArrayList<String> commodityNums) {
		this.commodityNums = commodityNums;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}
	
	
	
}
