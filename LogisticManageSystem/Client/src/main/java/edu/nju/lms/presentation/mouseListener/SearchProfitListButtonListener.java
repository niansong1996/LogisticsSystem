package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.lms.VO.PaymentVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.DateChooser;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.components.table.PayListTable;
import edu.nju.lms.presentation.components.table.PersonnelTable;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class SearchProfitListButtonListener extends ButtonListener {
	private ArrayList<PaymentVO> lists;
	private FinanceController finance;
	private DateChooser start;
	private DateChooser end;
	public SearchProfitListButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.lists = new ArrayList<PaymentVO>();
		this.finance = controller.getFinanceController();
		this.start = (DateChooser) units.get(0);
		this.end = (DateChooser) units.get(1);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Calendar s = Calendar.getInstance();
		s.setTime(start.getDate());
		Calendar d = Calendar.getInstance();
		d.setTime(end.getDate());
		lists = finance.showAllPayment(s, d);
		if(lists.isEmpty()){
			MyDialog dialog = new MyDialog("此段时间无账单",true);
		}
		ArrayList<MyTableLabel> labels = new ArrayList<MyTableLabel>();
		PayListTable table = (PayListTable)units.get(2);
		for (int i = 0; i < lists.size(); i++) {
			PaymentVO person = lists.get(i);
			MyTableLabel label = table.createLabel(person);
			labels.add(label);
		}
		table.setDataList(labels);
	}

}
