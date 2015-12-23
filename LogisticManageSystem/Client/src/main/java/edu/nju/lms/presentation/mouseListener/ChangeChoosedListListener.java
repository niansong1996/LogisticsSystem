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
 * @author tj
 * @date 2015年12月5日
 */
public abstract class ChangeChoosedListListener extends ButtonListener {
	protected ListController control;
	protected ListTable table;

	public ChangeChoosedListListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getListController();
		this.table = (ListTable) units.get(0);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ArrayList<MyTableLabel> data = table.getDataList();
		if (data.isEmpty()) {
			return;
		}
		ResultMessage result = null;
		for (int i = 0; i < data.size(); i++) {
			MyTableLabel label = data.get(i);
			MyCheckBox check = (MyCheckBox) label.getComponent(0);
			if (check.isSelected()) {
				ListVO vo = createVO(label);
				result = control.changeList(vo, vo.getType());
				if (result.isSuccess()) {
					table.my_remove(i);
					i--;
				}
				// 把之前双击显示的单据具体信息从界面上去掉
				LabelListener listener = (LabelListener) label.getMouseListeners()[0];
				if (listener != null) {
					Component area = listener.getArea();
					if (area != null) {
						area.setVisible(false);
						controller.getFrame().getPanel().repaint();
					}
				}
			}
		}
		if (result.isSuccess()) {
			new MyDialog("审批通过！", true);
		} else {
			new MyDialog(result.getErrorMessage(), true);
		}

	}

	/**
	 * 返回修改审批状态后的{@link ListVO}
	 * 
	 * @param label
	 * @return
	 */
	public abstract ListVO createVO(MyTableLabel label);
}
