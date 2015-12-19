package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.PaymentVO;
import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.DateChooser;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.components.table.PayListTable;
import edu.nju.lms.presentation.components.table.ReceiptTable;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class SearchProfitListButtonListener extends ButtonListener {
	private ArrayList<PaymentVO> lists;
	private ArrayList<ReceiptVO> receipts;
	private FinanceController finance;
	private DateChooser start;
	private DateChooser end;
	public SearchProfitListButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.lists = new ArrayList<PaymentVO>();
		this.receipts = new ArrayList<ReceiptVO>();
		this.finance = controller.getFinanceController();
		this.start = (DateChooser) units.get(0);
		this.end = (DateChooser) units.get(1);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//show payment
		lists = finance.showAllPayment(start.getCalendar(), end.getCalendar());
		receipts = finance.showReceiptList(start.getCalendar(),end.getCalendar());
		if(lists.isEmpty()&&receipts.isEmpty()){
			new MyDialog("此段时间无账单",true);
			return;
		}
		ArrayList<MyTableLabel> labels = new ArrayList<MyTableLabel>();
		PayListTable table = (PayListTable)units.get(2);
		for (int i = 0; i < lists.size(); i++) {
			PaymentVO person = lists.get(i);
			MyTableLabel label = table.createLabel(person);
			labels.add(label);
		}
		table.setDataList(labels);
		//show receipt
		ArrayList<MyTableLabel> labs = new ArrayList<MyTableLabel>();
		ReceiptTable tab = (ReceiptTable) units.get(3);
		for(int i = 0;i<receipts.size();i++){
			ReceiptVO vo = receipts.get(i);
			MyTableLabel l = tab.createLabel(vo);
			labs.add(l);
		}
		tab.setDataList(labs);
	}

}
