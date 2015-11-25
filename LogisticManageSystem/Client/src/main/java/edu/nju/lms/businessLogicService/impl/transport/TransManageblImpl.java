package edu.nju.lms.businessLogicService.impl.transport;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import edu.nju.lms.PO.DriverPO;
import edu.nju.lms.PO.VehiclePO;
import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.VO.DriverVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.TransportToolDataService;

public class TransManageblImpl{

	TransportToolDataService service;
	private static int basicCarNum=0;
	private static int basicDriverNum=0;
	
	public TransManageblImpl(TransportToolDataService tool){
		this.service=tool;
	}
	
	public VehicleVO addVehicle(VehicleVO vehicle) {
		VehicleVO car=vehicle;
		car.setVehicleNum(createCarNum(vehicle.getBusinessHallNum()));
		return car;
	}

	public ResultMessage saveVehicleInfor(VehicleVO vehicle) {
		ResultMessage result=check(vehicle.getBusinessHallNum());
		if(!result.isSuccess()){
			return result;
		}
		result=new ResultMessage(false,"网络未连接");
		VehiclePO po=new VehiclePO(vehicle.getVehicleNum(),vehicle.getPlateNum(),
				vehicle.getBusinessHallNum(),vehicle.getServiceYears());
		try {
			result=service.addVehicle(po);
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}

	public ResultMessage deleteVehicle(String vehicleNum) {
		ResultMessage result=idCheck(vehicleNum);
		if(!result.isSuccess()){
			return result;
		}
		result=new ResultMessage(false,"网络未连接");
		try {
			result=service.deleteVehicle(vehicleNum);
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}

	public ResultMessage updateVehicle(VehicleVO modified) {
		ResultMessage result=idCheck(modified.getVehicleNum(),modified.getBusinessHallNum());
		if(!result.isSuccess()){
			return result;
		}
		result=new ResultMessage(false,"网络未连接");
		VehiclePO po=new VehiclePO(modified.getVehicleNum(),modified.getPlateNum(),
				modified.getBusinessHallNum(),modified.getServiceYears());
		try {
			result=service.updateVehicle(po);
		} catch (RemoteException e) {
			// TODO 
		}
		return result;
	}

	public VehicleVO findVehicle(String vehicleNum) {
		VehicleVO result=null;
		VehiclePO po=null;
		try {
			po=service.findVehicle(vehicleNum);
			if(po!=null){
				result=new VehicleVO(po.getVehicleNum(),po.getPlateNum(),
				po.getBusinessHallNum(),po.getServiceYears());
			}
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}

	public DriverVO addDriver(DriverVO driver) {
		DriverVO result=driver;
		result.setDriverNum(createDriverNum(driver.getBusinesshallNum()));
		return result;
	}

	public ResultMessage saveDriverInfor(DriverVO driver) {
		ResultMessage result=check(driver.getBusinesshallNum());
		if(!result.isSuccess()){
			return result;
		}
		result=new ResultMessage(false,"网络未连接");
		String[] temp1=driver.getBirth().split("/");
		Calendar c1=Calendar.getInstance();
		c1.set(Integer.parseInt(temp1[0]), Integer.parseInt(temp1[1]),Integer.parseInt(temp1[2]));
		String[] temp2=driver.getDrivingLimit().split("/");
		Calendar c2=Calendar.getInstance();
		c2.set(Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]),Integer.parseInt(temp2[2]));
		
		DriverPO po=new DriverPO(driver.getDriverNum(),driver.getDriverName(),c1,driver.getIdNum(),
				driver.getPhoneNum(),driver.getSex(),c2,driver.getBusinesshallNum());
		try {
			result=service.addDriver(po);
		} catch (RemoteException e) {
			// TODO
		}
		//add the driver into the personnel
		PersonnelVO personnel=new PersonnelVO(driver.getDriverNum(),driver.getDriverName(),driver.getBusinesshallNum(),
				"司机",0,0,0);
		try {
			PersonnelController personnelController=BusinessLogicFactory.getPersonnelController();
			personnelController.addPersonnel(personnel);
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage deleteDriver(String driverNum) {
		ResultMessage result=idCheck(driverNum);
		if(!result.isSuccess()){
			return result;
		}
		result=new ResultMessage(false,"网络未连接");
		try {
			result=service.deleteDriver(driverNum);
		} catch (RemoteException e) {
			// TODO
		}
		try {
			PersonnelController personnelController=BusinessLogicFactory.getPersonnelController();
			personnelController.deletePersonnel(driverNum);
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage updateDriver(DriverVO driver) {
//		ResultMessage result=idCheck(modified.getVehicleNum(),modified.getBusinessHallNum());
//		if(!result.isSuccess()){
//			return result;
//		}
//		result=new ResultMessage(false,"网络未连接");
//		VehiclePO po=new VehiclePO(modified.getVehicleNum(),modified.getPlateNum(),
//				modified.getBusinessHallNum(),modified.getServiceYears());
//		try {
//			result=service.updateVehicle(po);
//		} catch (RemoteException e) {
//			// TODO 
//		}
//		return result;
		ResultMessage result=idCheck(driver.getDriverNum(),driver.getBusinesshallNum());
		if(!result.isSuccess()){
			return result;
		}
		result=new ResultMessage(false,"网络未连接");
		String[] temp1=driver.getBirth().split("/");
		Calendar c1=Calendar.getInstance();
		c1.set(Integer.parseInt(temp1[0]), Integer.parseInt(temp1[1]),Integer.parseInt(temp1[2]));
		String[] temp2=driver.getDrivingLimit().split("/");
		Calendar c2=Calendar.getInstance();
		c2.set(Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]),Integer.parseInt(temp2[2]));
		
		DriverPO po=new DriverPO(driver.getDriverNum(),driver.getDriverName(),c1,driver.getIdNum(),
				driver.getPhoneNum(),driver.getSex(),c2,driver.getBusinesshallNum());
		try {
			result=service.addDriver(po);
		} catch (RemoteException e) {
			// TODO 
		}
		PersonnelVO personnel=new PersonnelVO(driver.getDriverNum(),driver.getDriverName(),driver.getBusinesshallNum(),
				"司机",0,0,0);
		try {
			PersonnelController personnelController=BusinessLogicFactory.getPersonnelController();
			personnelController.updatePersonnel(personnel);
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
		return result;
	}

	public DriverVO findDriver(String vehicleNum) {
		DriverVO result=null;
		DriverPO po=null;
		try {
			po=service.findDriver(vehicleNum);
			if(po!=null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				String birth=sdf.format(po.getBirth());
				String drivingLimit=sdf.format(po.getDrivingLimit());
				result=new DriverVO(po.getDriverNum(),po.getDriverName(),birth,po.getIdNum(),
						po.getPhoneNum(),po.getSex(),drivingLimit,po.getBusinesshallNum());
			}
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}

	public String createCarNum(String businessNum){
		String temp=String.valueOf(basicCarNum);
		while(temp.length()<3){
			temp="0"+temp;
		}
		String result=businessNum+temp;
		basicCarNum++;
		return result;
	}
	public String createDriverNum(String businessNum){
		String temp=String.valueOf(basicDriverNum);
		while(temp.length()<3){
			temp="0"+temp;
		}
		String result=businessNum+temp;
		basicDriverNum++;
		return result;
	}
	public ResultMessage check(String businessNum){
		ResultMessage result=new ResultMessage(true,"");
		try {
			DepartmentController departController=BusinessLogicFactory.getDepartmentController();
			DepartmentVO depart=departController.getDepartInfo(businessNum);
			if(depart==null){
				result.setSuccess(false);
				result.setErrorMessage("未找到该机构！");
			}
		} catch (NoBusinessLogicException e) {
			e.printStackTrace();
		}
		return result;
	}
	public ResultMessage idCheck(String id){
		ResultMessage result=new ResultMessage(true,"");
		if(id.length()!=9){
			result.setSuccess(false);
			result.setErrorMessage("输入编号位数不正确！");
		}
		return result;
	}
	public ResultMessage idCheck(String id,String businessNum){
		ResultMessage result=new ResultMessage(true,"");
		if(id.length()!=9){
			result.setSuccess(false);
			result.setErrorMessage("输入编号位数不正确！");
		}
		if(!id.substring(0, 6).equals(businessNum)){
			result.setSuccess(false);
			result.setErrorMessage("输入的编号应与营业厅相符");
		}
		return result;
	}
}
