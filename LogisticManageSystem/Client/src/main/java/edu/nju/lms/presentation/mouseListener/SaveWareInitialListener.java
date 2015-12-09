package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.PartitionVO;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.data.Partition;
import edu.nju.lms.data.PartitionType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 *@author tj
 *@date 2015年12月7日
 */
public class SaveWareInitialListener extends ButtonListener {
	private WarehouseController control;
	public SaveWareInitialListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getWarehouseController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JTextField cordon = (JTextField)units.get(0);
		if(!Numeric.isNumeric(cordon.getText())){
			new MyDialog("请输入合法数字",true);
			return;
		}
		double cordonLine = Double.parseDouble(cordon.getText());
		JTextField warehouseNum = (JTextField)units.get(1);
		ArrayList<Partition> partitions = new ArrayList<Partition>();
		for(int i =2;i<6;i++){
			JTextField start = (JTextField)units.get(i);
			JTextField end = (JTextField)units.get(i+1);
			if(!Numeric.isNumeric(start.getText())||!Numeric.isNumeric(end.getText())){
				new MyDialog("请输入合法数字",true);
				return;
			}
			int startIndex = Integer.parseInt(start.getText());
			int endIndex = Integer.parseInt(end.getText());
			int capacity = endIndex - startIndex;
			if(capacity<0){
				new MyDialog("请输入合法数字",true);
				return;
			}
			Partition partition = new Partition(capacity,startIndex,endIndex,PartitionType.values()[i-2]);
			partitions.add(partition);
		}
		PartitionVO vo = new PartitionVO(partitions);
		ResultMessage result = control.initialize(vo, cordonLine, warehouseNum.getText());
		if(result.isSuccess()){
			new MyDialog("初始化成功",true);
		}else{
			new MyDialog(result.getErrorMessage(),true);
		}
	}

}
