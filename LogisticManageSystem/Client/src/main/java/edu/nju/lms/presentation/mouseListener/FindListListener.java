package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.EnumTransformer;
import edu.nju.lms.VO.ListVO;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.data.ListType;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.ListTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class FindListListener extends ButtonListener {
	private ListController control;
	private ArrayList<ListVO> lists;
	private ListTable table;
	private ArrayList<MyTableLabel> labels;
	public FindListListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getListController();
		lists = new ArrayList<ListVO>();
		table = (ListTable) units.get(0);
		labels = new ArrayList<MyTableLabel>();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JTextField idField = (JTextField) units.get(2);
		String id = idField.getText();
		idField.setText("");
		if(id.isEmpty()){
			MyComboBox box = (MyComboBox) units.get(1);
			String type = (String) box.getSelectedItem();
			ListType listType = EnumTransformer.str2ListType(type);
			lists = control.getListInfo(listType);
			if(lists.isEmpty()){
				new MyDialog("单据不存在",true);
				return;
			}
			for(int i=0;i<lists.size();i++){
				lists.get(i).setType(listType);
				MyTableLabel label = table.createLabel(lists.get(i));
				labels.add(label);
			}
		}else{
			ListVO vo = control.getListInfo(id);
			if(vo==null){
				new MyDialog("单据不存在",true);
				return;
			}
			MyTableLabel label = table.createLabel(vo);
			labels.add(label);
		}
		table.setDataList(labels);
	}

}
