package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.util.ArrayList;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.data.ListState;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.EnumTransformer;
import edu.nju.lms.presentation.components.MyLabel;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class FailChoosedListListener extends ChangeChoosedListListener {
	public FailChoosedListListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}

	@Override
	public ListVO createVO(MyTableLabel label) {
		MyLabel id = (MyLabel) label.getComponents(1);
		ListVO vo = new ListVO(id.getText());
		MyLabel type = (MyLabel) label.getComponents(0);
		vo.setType(EnumTransformer.str2ListType(type.getText()));
		vo.setState(ListState.DENY);
		return vo;
	}

	

}
