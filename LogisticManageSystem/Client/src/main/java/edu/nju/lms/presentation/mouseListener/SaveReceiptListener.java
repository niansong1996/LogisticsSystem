package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.ReceiptVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;
import edu.nju.lms.presentation.components.table.CommodityTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 * save receipt
 * @author cuihao
 * @date 2015-12-07 10:52:43
 */
public class SaveReceiptListener extends ButtonListener{

	FinanceController finance;
	
	public SaveReceiptListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		finance = controller.getFinanceController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MyTextField courier = (MyTextField) units.get(3);
		MyTextField money = (MyTextField) units.get(4);
		CommodityTable table = (CommodityTable) units.get(0);
		ArrayList<String> express = new ArrayList<String>();
		for(MyTableLabel label: table.getDataList()) {
			MyTextField commodity = (MyTextField) label.getComponents(0);
			express.add(commodity.getText());
		}
		ReceiptVO receipt = new ReceiptVO("", "", Double.parseDouble(money.getText()), courier.getText(), express);
		ReceiptVO finalReceipt = finance.createReceipt(receipt);
		ResultMessage result = finance.addReceipt(finalReceipt);
		if(result.isSuccess()) {
			new MyDialog("addSuccess");
		}else{
			new MyDialog(result.getErrorMessage(),true);
		}
	}

}
