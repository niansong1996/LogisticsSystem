package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyCheckBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.ListTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class PassSingleListListener extends ButtonListener {
	protected ListController control;
	
	public PassSingleListListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getListController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
