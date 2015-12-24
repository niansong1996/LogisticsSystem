package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.PO.Location;
import edu.nju.lms.VO.CheckinVO;
import edu.nju.lms.VO.EnumTransformer;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.CheckInTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 * @author tj
 * @date 2015年12月7日
 */
public class CreateCheckInListener extends ButtonListener {
	private WarehouseController control;
	private CheckInTable table;
	private ArrayList<String> expressNums;
	private ArrayList<String> exDestination;
	private ArrayList<Location> location;

	public CreateCheckInListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getWarehouseController();
		this.table = (CheckInTable) units.get(5);
		this.expressNums = new ArrayList<String>();
		this.exDestination = new ArrayList<String>();
		this.location = new ArrayList<Location>();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ArrayList<MyTableLabel> labels = table.getDataList();
		if (labels.isEmpty()) {
			return;
		}
		for (MyTableLabel label : labels) {
			JTextField field = (JTextField) label.getComponents(0);
			if(field.getText().isEmpty()){
				return;
			}
			expressNums.add(field.getText());
			JTextField desti = (JTextField) label.getComponents(4);
			if(desti.getText().isEmpty()){
				return;
			}
			exDestination.add(desti.getText() + "");
			Location loc = createLocation();
			if(loc==null){
				return;
			}
			location.add(loc);
		}
		CheckinVO vo = new CheckinVO(null, location, expressNums, exDestination);
		vo = control.createCheckinList(vo, control.getCurrentWarehouseNum());
		ResultMessage result = control.saveCheckinList(vo, control.getCurrentWarehouseNum());
		if(result.isSuccess()){
			new MyDialog("入库成功",true,controller);
		}else{
			new MyDialog(result.getErrorMessage(),true,controller);
		}
	}

	private Location createLocation() {
		JTextField field = (JTextField)units.get(1);
		if(!Numeric.isNumeric(field.getText())){
			return null;
		}
		String lineNum = field.getText();
		JTextField ite = (JTextField)units.get(2);
		if(!Numeric.isNumeric(ite.getText())){
			return null;
		}
		String item = ite.getText();
		MyComboBox<?> box = (MyComboBox<?>) units.get(4);
		String str = (String) box.getSelectedItem();
		PartitionType type = EnumTransformer.str2PartitionType(str);
		Location loc = new Location(type,Integer.parseInt(lineNum),Integer.parseInt(item));
		return loc;
	}

}
