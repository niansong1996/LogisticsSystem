package edu.nju.lms.presentation.components.table;

import java.util.ArrayList;

import org.dom4j.Element;

import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController;

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
		vehicles = new ArrayList<VehicleVO>();
		for(int i = 0; i < vehicles.size(); i++) {
			MyTableLabel label = createLabel(vehicles.get(i));
			addData(label);
		}
		
	}
	
	private MyTableLabel createLabel(VehicleVO vehicle) {
		return null;
	}

}
