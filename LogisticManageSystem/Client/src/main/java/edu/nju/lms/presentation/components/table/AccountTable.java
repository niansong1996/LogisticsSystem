package edu.nju.lms.presentation.components.table;

import java.util.ArrayList;

import org.dom4j.Element;

import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyLabel;

/**
 *@author tj
 *@date 2015年12月7日
 */
public class AccountTable extends MyTable {

	private static final long serialVersionUID = -1356165825343162242L;
	private ArrayList<AccountVO> accounts;
	private FinanceController control;
	public AccountTable(Element element, UIController controller) {
		super(element, controller);
		accounts = new ArrayList<AccountVO>();
		control = controller.getFinanceController();
	}

	@Override
	protected void getData() {
		control = controller.getFinanceController();
		accounts = control.showAllAccount();
		if(accounts.isEmpty()){
			return;
		}
		for (int i = 0; i < accounts.size(); i++) {
			MyTableLabel label = createLabel(accounts.get(i));
			addData(label);
		}
	}
	public MyTableLabel createLabel(AccountVO vo){
		MyLabel name = new MyLabel(vo.getID());
		name.setSize(200,30);
		MyLabel balance = new MyLabel(vo.getAmount()+"");
		balance.setSize(50,30);
		java.awt.Component[] component = {name, balance};
		MyTableLabel label = new MyTableLabel(element, controller, 50, component, this);
		return label;
	}

	@Override
	protected ResultMessage deleteData(MyTableLabel label) {
		MyLabel name = (MyLabel) label.getComponents(0);
		return control.deleteAccount(name.getText());
	}
}
