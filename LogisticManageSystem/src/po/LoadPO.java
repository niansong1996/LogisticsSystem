package po;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *@author tj
 *@date ����5:12:31
 */
public class LoadPO {
	//load type
	private LoadType loadType;
	//װ������
	private Calendar loadDate;
	//Ӫҵ�����
	private long businessHallNum;
	//���˱��
	private long motorNum;
	//������ת���Ļ�Ӫҵ��
	private CityPO destiCity;
	private long destiBusinessHall;
	private long vehicleNum;
	private long driverNum;
	//����װ�����ж���������
	private ArrayList<Long> commodityNums;
	
	private double freight;

	public LoadPO(LoadType loadType,Calendar loadDate, long businessHallNum, long motorNum, CityPO destiCity, long destiBusinessHall,
			long vehicleNum, long driverNum, ArrayList<Long> commodityNums, double freight) {
		super();
		this.loadType = loadType;
		this.loadDate = loadDate;
		this.businessHallNum = businessHallNum;
		this.motorNum = motorNum;
		this.destiCity = destiCity;
		this.destiBusinessHall = destiBusinessHall;
		this.vehicleNum = vehicleNum;
		//��װԱ��Ѻ��Ա��˾��������driver 
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

	public long getBusinessHallNum() {
		return businessHallNum;
	}

	public void setBusinessHallNum(long businessHallNum) {
		this.businessHallNum = businessHallNum;
	}

	public long getMotorNum() {
		return motorNum;
	}

	public void setMotorNum(long motorNum) {
		this.motorNum = motorNum;
	}

	public CityPO getDestiCity() {
		return destiCity;
	}

	public void setDestiCity(CityPO destiCity) {
		this.destiCity = destiCity;
	}

	public long getDestiBusinessHall() {
		return destiBusinessHall;
	}

	public void setDestiBusinessHall(long destiBusinessHall) {
		this.destiBusinessHall = destiBusinessHall;
	}

	public long getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(long vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public long getDriverNum() {
		return driverNum;
	}

	public void setDriverNum(long driverNum) {
		this.driverNum = driverNum;
	}

	public ArrayList<Long> getCommodityNums() {
		return commodityNums;
	}

	public void setCommodityNums(ArrayList<Long> commodityNums) {
		this.commodityNums = commodityNums;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}
	
	
	
}
