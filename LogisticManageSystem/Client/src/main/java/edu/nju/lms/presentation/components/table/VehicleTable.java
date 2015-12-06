package edu.nju.lms.presentation.components.table;

import java.util.ArrayList;

import org.dom4j.Element;

import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyTextField;

/**
 * vehicle manage table
 * @author cuihao
 * @date 2015-12-04 16:49:58
 */
public class VehicleTable extends MyTable{

	private static final long serialVersionUID = -865017252114583444L;
	
	private ArrayList<VehicleVO> vehicles;
	private TransportController transport;

	public VehicleTable(Element element, UIController controller) {
		super(element, controller);
		vehicles = new ArrayList<VehicleVO>();
		transport = controller.getTransportController();
	}

	@Override
	protected void getData() {
		transport = controller.getTransportController();
		VehicleVO vehicle = new VehicleVO("123456", "sf216fu", "1234512345", 10);
		vehicles = new ArrayList<VehicleVO>();
		vehicles.add(vehicle);
		for(int i = 0; i < vehicles.size(); i++) {
			MyTableLabel label = createLabel(vehicles.get(i));
			addData(label);
		}
		
	}
	
	public MyTableLabel createLabel(VehicleVO vehicle) {
		MyTextField plateNum = new MyTextField(vehicle.getPlateNum());
		plateNum.setSize(150,30);
		MyTextField vehicleNum = new MyTextField(vehicle.getVehicleNum());
		vehicleNum.setSize(150,30);
		MyTextField years = new MyTextField(vehicle.getServiceYears()+"");
		years.setSize(100,30);
		MyTextField bussinesshall = new MyTextField(vehicle.getBusinessHallNum());
		bussinesshall.setSize(200,30);
		java.awt.Component component[] = {plateNum, vehicleNum, years, bussinesshall};
		MyTableLabel label = new MyTableLabel(element, controller, 50, component, this);
		return label;
	}

}
