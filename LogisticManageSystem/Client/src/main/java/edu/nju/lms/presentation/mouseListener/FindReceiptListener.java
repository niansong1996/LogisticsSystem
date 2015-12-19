package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextField;

import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.DateChooser;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.components.table.SumReceiptTable;

/**
 *@author tj
 *@date 2015年12月7日
 */
public class FindReceiptListener extends ButtonListener {
	private FinanceController control;
	private SumReceiptTable table;
	public FindReceiptListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getFinanceController();
		this.table = (SumReceiptTable) units.get(0);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JTextField id = (JTextField) units.get(3);
		DateChooser date = (DateChooser) units.get(1);
		if(id.getText().isEmpty()){
			new MyDialog("incomplete");
			return;
		}
		Calendar cal = date.getCalendar();
		ArrayList<ReceiptVO> receipts = control.showReceiptList(cal, id.getText());
		if(receipts.isEmpty()){
			new MyDialog("不存在对应收款单",true);
			return;
		}
		ArrayList<MyTableLabel> labels = new ArrayList<MyTableLabel>();
		for(int i =0;i<receipts.size();i++){
			ReceiptVO vo = receipts.get(i);
			labels.add(table.createLabel(vo, id.getText()));
		}
		table.setDataList(labels);
	}

}
