package edu.nju.lms.businessLogicService.impl.transport;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.lms.PO.DriverPO;
import edu.nju.lms.PO.VehiclePO;
import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.VO.DriverVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelController;
import edu.nju.lms.businessLogicService.impl.utility.RemoteExceptionHandler;
import edu.nju.lms.data.CommonUtility;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.TransportToolDataService;

public class TransManageblImpl{
	
	public TransManageblImpl(){
	}
	
	public VehicleVO addVehicle(ListController listController,VehicleVO vehicle) {
		VehicleVO car=vehicle;
		car.setVehicleNum(vehicle.getBusinessHallNum()+listController.applyListNum(ListType.CAR));
		return car;
	}

	public ResultMessage saveVehicleInfor(DepartmentController departmentController,TransportToolDataService service,VehicleVO vehicle) {
		ResultMessage result=check(departmentController,vehicle.getBusinessHallNum());
		if(!result.isSuccess()){
			return result;
		}
		VehiclePO po=new VehiclePO(vehicle.getVehicleNum(),vehicle.getPlateNum(),
				vehicle.getBusinessHallNum(),vehicle.getServiceYears());
		try {
			result=service.addVehicle(po);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public ResultMessage deleteVehicle(TransportToolDataService service,String vehicleNum) {
		ResultMessage result=idCheck(vehicleNum);
		if(!result.isSuccess()){
			return result;
		}
		try {
			result=service.deleteVehicle(vehicleNum);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public ResultMessage updateVehicle(TransportToolDataService service,VehicleVO modified) {
		ResultMessage result=idCheck(modified.getVehicleNum(),modified.getBusinessHallNum());
		if(!result.isSuccess()){
			return result;
		}
		VehiclePO po=new VehiclePO(modified.getVehicleNum(),modified.getPlateNum(),
				modified.getBusinessHallNum(),modified.getServiceYears());
		try {
			result=service.updateVehicle(po);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public VehicleVO findVehicle(TransportToolDataService service,String vehicleNum) {
		VehicleVO result=null;
		VehiclePO po=null;
		try {
			po=service.findVehicle(vehicleNum);
			if(po!=null){
				result=new VehicleVO(po.getVehicleNum(),po.getPlateNum(),
				po.getBusinessHallNum(),po.getServiceYears());
			}
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}

	public ArrayList<VehicleVO> showAllVehicles(TransportToolDataService service){
		ArrayList<VehicleVO> result=new ArrayList<VehicleVO>();
		ArrayList<VehiclePO> po=null;
		try {
			po=service.showAllVihicle();
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(po!=null){
			for(VehiclePO temp : po){
				VehicleVO vo=new VehicleVO(temp.getVehicleNum(),temp.getPlateNum(),
						temp.getBusinessHallNum(),temp.getServiceYears());
				result.add(vo);
			}
		}
		return result;
	}
	
	public DriverVO addDriver(ListController listController,DriverVO driver) {
		DriverVO result=driver;
		result.setDriverNum(driver.getBusinesshallNum()+listController.applyListNum(ListType.DRIVER));
		return result;
	}

	public ResultMessage saveDriverInfor(PersonnelController personnelController,DepartmentController departmentController,TransportToolDataService service,DriverVO driver) {
		ResultMessage result=check(departmentController,driver.getBusinesshallNum());
		if(!result.isSuccess()){
			return result;
		}
		DriverPO po=new DriverPO(driver.getDriverNum(),driver.getDriverName(),CommonUtility.String2Cal(driver.getBirth()),
				driver.getIdNum(),driver.getPhoneNum(),driver.getSex(),CommonUtility.String2Cal(driver.getDrivingLimit()),driver.getBusinesshallNum());
		try {
			result=service.addDriver(po);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		//add the driver into the personnel
		PersonnelVO personnel=new PersonnelVO(driver.getDriverNum(),driver.getDriverName(),driver.getBusinesshallNum(),"司机",0,0,0);
		personnelController.addPersonnel(personnel);
		return result;
	}

	public ResultMessage deleteDriver(PersonnelController personnelController,TransportToolDataService service,String driverNum) {
		ResultMessage result=idCheck(driverNum);
		if(!result.isSuccess()){
			return result;
		}
		try {
			result=service.deleteDriver(driverNum);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		personnelController.deletePersonnel(driverNum);
		return result;
	}

	public ResultMessage updateDriver(PersonnelController personnelController,TransportToolDataService service,DriverVO driver) {
		ResultMessage result=idCheck(driver.getDriverNum(),driver.getBusinesshallNum());
		if(!result.isSuccess()){
			return result;
		}
	
		DriverPO po=new DriverPO(driver.getDriverNum(),driver.getDriverName(),CommonUtility.String2Cal(driver.getBirth()),
				driver.getIdNum(),driver.getPhoneNum(),driver.getSex(),CommonUtility.String2Cal(driver.getDrivingLimit()),driver.getBusinesshallNum());
		try {
			result=service.addDriver(po);
		} catch (RemoteException e) {
			return RemoteExceptionHandler.handleRemoteException(e);
		}
		PersonnelVO personnel=new PersonnelVO(driver.getDriverNum(),driver.getDriverName(),driver.getBusinesshallNum(),"司机",0,0,0);
		personnelController.updatePersonnel(personnel);
		return result;
	}

	public DriverVO findDriver(TransportToolDataService service,String vehicleNum) {
		DriverVO result=null;
		DriverPO po=null;
		try {
			po=service.findDriver(vehicleNum);
			if(po!=null){
				result=new DriverVO(po.getDriverNum(),po.getDriverName(),CommonUtility.Cal2String(po.getBirth()),
						po.getIdNum(),po.getPhoneNum(),po.getSex(),CommonUtility.Cal2String(po.getDrivingLimit()),po.getBusinesshallNum());
			}
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		return result;
	}
	
	public ArrayList<DriverVO> findAllDrivers(TransportToolDataService service){
		ArrayList<DriverVO> result=new ArrayList<DriverVO>();
		ArrayList<DriverPO> po=null;
		try {
			po=service.showAllDrivers();
		} catch (RemoteException e) {
			RemoteExceptionHandler.handleRemoteException(e);
		}
		if(po!=null){
			for(DriverPO temp : po){
				DriverVO driver=new DriverVO(temp.getDriverNum(), temp.getDriverName(), CommonUtility.Cal2String(temp.getBirth()), 
						temp.getIdNum(), temp.getPhoneNum(), temp.getSex(), CommonUtility.Cal2String(temp.getDrivingLimit()), temp.getBusinesshallNum());
				result.add(driver);
			}
		}
		return result;
	}

	public ResultMessage check(DepartmentController departmentController,String businessNum){
		ResultMessage result=new ResultMessage(true,"");
		DepartmentVO depart=departmentController.getDepartInfo(businessNum);
		if(depart==null){
			result.setSuccess(false);
			result.setErrorMessage("未找到该机构！");
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
