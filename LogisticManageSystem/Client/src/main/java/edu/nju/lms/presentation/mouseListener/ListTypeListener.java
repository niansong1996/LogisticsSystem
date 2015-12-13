package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.data.ListType;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.EnumTransformer;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.ListTable;
import edu.nju.lms.presentation.components.table.MyTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 * @author tj
 * @date 2015年12月5日
 */
public class ListTypeListener implements ItemListener {
	protected ArrayList<java.awt.Component> units;
	protected UIController controller;
	protected MyComboBox box;
	private ListController listControl;
	private ListTable table;

	public ListTypeListener(ArrayList<java.awt.Component> units, UIController controller, Component box) {
		this.units = units;
		this.controller = controller;
		this.box = (MyComboBox) box;
		this.listControl = controller.getListController();
		this.table = (ListTable) units.get(0);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			ListType type = EnumTransformer.str2ListType((String) e.getItem());
			if (listControl != null) {
				ArrayList<ListVO> lists = listControl.getListInfo(type);
				if(lists.isEmpty()){
					new MyDialog("单据不存在",true);
					return;
				}
				ArrayList<MyTableLabel> labels = new ArrayList<MyTableLabel>();
				for (int i = 0; i < lists.size(); i++) {
					ListVO list = lists.get(i);
					list.setType(type);
					MyTableLabel label = table.createLabel(list);
					labels.add(label);
				}
				table.setDataList(labels);
			}
		}

	}

}
