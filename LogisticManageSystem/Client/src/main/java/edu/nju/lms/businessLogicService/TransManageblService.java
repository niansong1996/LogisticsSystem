package edu.nju.lms.businessLogicService;

import java.util.ArrayList;

import edu.nju.lms.VO.DriverVO;
import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.data.ResultMessage;

/**
 * service used to manage {@link DriverVO} and {@link VehicleVO}
 * @author Cui
 * last modified: 2015-10-25 11:14:56
 */
public interface TransManageblService {
	
	/**
	 * complete the information of a {@link VehicleVO}
	 * @param plateNum
	 * @return completed VehicleVO
	 * @see VehicleVO
	 */
	public VehicleVO addVehicle(VehicleVO plateNum);

	/**
	 * After the user confirm the vehicle info, system will save the vehicle
	 * @param vehicleInfor
	 * @return {@link ResultMessage}
	 * @see ResultMessage
	 */
	public ResultMessage saveVehicleInfor(VehicleVO vehicleInfor);
	
	/**
	 * find a vehicle by id, and the delete it.
	 * @param vehicleNum
	 * @return {@link ResultMessage}
	 * @see ResultMessage
	 */
	public ResultMessage deleteVehicle(String vehicleNum);
	
	/**
	 * find a vehicle by id, replace it using the parameter
	 * @param modified
	 * @return {@link ResultMessage}
	 * @see ResultMessage
	 * @see VehicleVO
	 */
	public ResultMessage updateVehicle(VehicleVO modified );
	
	public ArrayList<VehicleVO> showAllVehicle();
	
	/**
	 * find a {@link VehicleVO} by id
	 * @param vehicleNum:long
	 * @return {@link VehicleVO}
	 */
	public VehicleVO findVehicle(String vehicleNum);
	
	/**
	 * complete the information of a {@link DriverVO}
	 * @param driverNum
	 * @return completed DriverVO
	 * @see DriverVO
	 */
	public DriverVO addDriver(DriverVO driverNum);

	/**
	 * After the user confirm the Driver info, system will save the Driver
	 * @param driverInfor
	 * @return {@link ResultMessage}
	 * @see ResultMessage
	 */
	public ResultMessage saveDriverInfor(DriverVO driverInfor);
	
	/**
	 * find a driver by id, and then delete it.
	 * @param driverNum
	 * @return {@link ResultMessage}
	 * @see ResultMessage
	 */
	public ResultMessage deleteDriver(String driverNum);
	
	/**
	 * find a driver by id, replace it using the parameter
	 * @param modified
	 * @return {@link ResultMessage}
	 * @see ResultMessage
	 * @see DriverVO
	 */
	public ResultMessage updateDriver(DriverVO modified );
	
	/**
	 * find a {@link DriverVO} by id
	 * @param driverNum:long
	 * @return {@link DriverVO}
	 */
	public DriverVO findDriver(String vehicleNum);
	
	public ArrayList<DriverVO> findAllDrivers();
}
