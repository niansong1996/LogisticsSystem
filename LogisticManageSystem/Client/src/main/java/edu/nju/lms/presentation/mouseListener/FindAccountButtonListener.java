package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.AccountTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 * @author tj
 * @date 2015年12月7日
 */
public class FindAccountButtonListener extends ButtonListener {

	public FindAccountButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		FinanceController control = controller.getFinanceController();
		JTextField idField = (JTextField) units.get(2);
		String id = idField.getText();
		if (id.isEmpty()) {
			return;
		}
		if (control != null) {
			idField.setText("");
			AccountVO vo = control.showAccount(id);
			if(vo==null){
				new MyDialog("账户不存在",true,controller);
				return;
			}
			ArrayList<MyTableLabel> labels = new ArrayList<MyTableLabel>();
			AccountTable table = (AccountTable) units.get(0);
			MyTableLabel label = table.createLabel(vo);
			labels.add(label);
			table.setDataList(labels);
		}
	}

}
