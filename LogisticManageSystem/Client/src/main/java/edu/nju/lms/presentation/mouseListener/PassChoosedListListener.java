package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.util.ArrayList;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.data.ListState;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyLabel;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class PassChoosedListListener extends ChangeChoosedListListener {
	public PassChoosedListListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}
	
	public ListVO createVO(MyTableLabel label){
		MyLabel id = (MyLabel) label.getComponents(1);
		ListVO vo = new ListVO(id.getText());
		MyLabel type = (MyLabel) label.getComponents(0);
		vo.setType(type.getText());
		vo.setState(ListState.PASS);
		return vo;
	}

}
