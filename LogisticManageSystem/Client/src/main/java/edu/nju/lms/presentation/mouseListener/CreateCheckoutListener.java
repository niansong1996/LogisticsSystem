package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.CheckoutVO;
import edu.nju.lms.VO.EnumTransformer;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.CheckoutTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 * @author tj
 * @date 2015年12月7日
 */
public class CreateCheckoutListener extends ButtonListener {
	private WarehouseController control;
	private CheckoutTable table;
	private ArrayList<String> expressNums;
	private ArrayList<String> exDestination;
	private String arrivalNum;
	private String loadType;
	private String motoNum;

	public CreateCheckoutListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getWarehouseController();
		this.expressNums = new ArrayList<String>();
		this.exDestination = new ArrayList<String>();
		this.table = (CheckoutTable) units.get(5);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ArrayList<MyTableLabel> labels = table.getDataList();
		if (labels.isEmpty()) {
			return;
		}
		MyTableLabel lab = labels.get(0);
		JTextField a = (JTextField) lab.getComponents(1);
		arrivalNum = a.getText();
		JTextField b = (JTextField) lab.getComponents(2);
		motoNum = b.getText();
		MyComboBox<?> box = (MyComboBox<?>) lab.getComponents(4);
		loadType = (String) box.getSelectedItem();
		boolean isConsist = true;
		for (MyTableLabel label : labels) {
			JTextField field = (JTextField) label.getComponents(0);
			if (field.getText().isEmpty()) {
				new MyDialog("incomplete");
				return;
			}
			expressNums.add(field.getText());
			JTextField arrival = (JTextField) label.getComponents(1);
			if (!arrival.getText().equals(arrivalNum)) {
				isConsist = false;
			}
			JTextField moto = (JTextField) label.getComponents(2);
			if (!moto.getText().equals(motoNum)) {
				isConsist = false;
			}
			JTextField desti = (JTextField) label.getComponents(3);
			exDestination.add(desti.getText());
			MyComboBox<?> bo = (MyComboBox<?>) label.getComponents(4);
			String type = (String) bo.getSelectedItem();
			if (!type.equals(loadType)) {
				isConsist = false;
			}
		}
		if (!isConsist) {
			new MyDialog("请保持所有到达单号、汽运编号和装运形式一致", true);
		}
		createVO();
	}
	private void createVO(){
		CheckoutVO vo = new CheckoutVO(null,expressNums,exDestination,EnumTransformer.str2LoadType(loadType),
				arrivalNum,motoNum);
		JTextField field = (JTextField) units.get(7);
		if (field.getText().isEmpty()) {
			return;
		}
		vo = control.createCheckoutList(vo, field.getText());
		ResultMessage result = control.saveCheckoutList(vo, field.getText());
		if(result.isSuccess()){
			new MyDialog("出库成功",true);
		}else{
			new MyDialog(result.getErrorMessage(),true);
		}
	}

}
