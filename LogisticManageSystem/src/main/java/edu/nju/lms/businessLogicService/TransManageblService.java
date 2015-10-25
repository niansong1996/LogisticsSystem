package edu.nju.lms.businessLogicService;

import edu.nju.lms.VO.VehicleVO;

public interface TransManageblService {
	
	/**
	 * complete the information of a Ve
	 * @param plateNum
	 * @return
	 */
	public VehicleVO addVehicle(VehicleVO plateNum);

}
