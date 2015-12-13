package edu.nju.lms.VO;

import java.util.ArrayList;

import edu.nju.lms.data.LoadType;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class LoadVO extends ListVO{
		//load type
		private LoadType loadType;
		//load date
		private String loadDate;
		//the number of yingyeting
		private String businessHallNum;
		//qiyunbianhao
		private String motorNum;
		//destiny
		private String destiCity;
		//the number of destiny businesshall
		private String destiBusinessHall;
		//cheliangdaihao
		private String vehicleNum;
		private String driverNum;
		//kuaidibianhao
		private ArrayList<String> commodityNums;
		
		private double freight;

		public LoadVO(String id,LoadType loadType,String loadDate, String businessHallNum, String motorNum, String destiCity, String destiBusinessHall,
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
		public String getLoadDate() {
			return loadDate;
		}

		public void setLoadDate(String loadDate) {
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
