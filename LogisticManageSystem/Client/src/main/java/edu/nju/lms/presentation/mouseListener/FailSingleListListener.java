package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyLabel;
import edu.nju.lms.presentation.components.table.ListTable;

/**
 * @author tj
 * @date 2015年12月5日
 */
public class FailSingleListListener extends ButtonListener {

	public FailSingleListListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ResultMessage result = null;
		//TODO
		if (result.isSuccess()) {
			MyDialog dialog = new MyDialog("审批通过！", true);
		} else {
			MyDialog dialog = new MyDialog(result.getErrorMessage(), true);
		}
	}

}
