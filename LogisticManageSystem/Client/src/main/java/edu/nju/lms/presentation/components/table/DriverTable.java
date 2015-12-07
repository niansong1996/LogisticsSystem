package edu.nju.lms.presentation.components.table;

import java.util.ArrayList;

import org.dom4j.Element;

import edu.nju.lms.VO.DriverVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyTextField;

public class DriverTable extends MyTable{

	private static final long serialVersionUID = 8158931247558228237L;
	
	private ArrayList<DriverVO> drivers;
	private TransportController transport;

	public DriverTable(Element element, UIController controller) {
		super(element, controller);
		transport = controller.getTransportController();
	}

	@Override
	protected void getData() {
		drivers = new ArrayList<DriverVO>();
		for(int i = 0; i < drivers.size(); i++) {
			MyTableLabel label = createLabel(drivers.get(i));
			addData(label);
		}
	}
	
	public MyTableLabel createLabel(DriverVO driver) {
		MyTextField driverNum = new MyTextField(driver.getDriverNum());
		driverNum.setSize(100,30);
		MyTextField name = new MyTextField(driver.getDriverName());
		name.setSize(65,30);
		MyTextField birth = new MyTextField(driver.getBirth());
		birth.setSize(100,30);
		MyTextField id = new MyTextField(driver.getIdNum());
		id.setSize(100,30);
		MyTextField phone = new MyTextField(driver.getPhoneNum());
		phone.setSize(110,30);
		MyComboBox<String> sex = new MyComboBox<String>(element, controller);
		if(driver.getSex()==0) {
			sex.setSelectedItem("男");
		}else{
			sex.setSelectedItem("女");
		}
		sex.setSize(60,30);
		MyTextField year = new MyTextField(driver.getDrivingLimit());
		year.setSize(35,30);
		MyTextField hall = new MyTextField(driver.getBusinesshallNum());
		hall.setSize(100,30);
		java.awt.Component components[] = {driverNum, name, birth, id, phone, sex, year, hall};
		MyTableLabel label = new MyTableLabel(element, controller, 50, components, this);
		return label;
	}

}
