package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import edu.nju.lms.VO.EarningVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyLabel;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.components.table.PayListTable;
import edu.nju.lms.presentation.components.table.ReceiptTable;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class ExportListButtonListener extends ButtonListener {
	private PayListTable table;
	private ReceiptTable receiptTable;
	public ExportListButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		table = (PayListTable) units.get(2);
		receiptTable = (ReceiptTable) units.get(3);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		FinanceController finance = controller.getFinanceController();
		String date = "2016-01-05";
		ArrayList<MyTableLabel> payLabels = table.getDataList();
		double pay = 0;
		for(int i = 0;i<payLabels.size();i++){
			MyTableLabel label = payLabels.get(i);
			MyLabel text = (MyLabel) label.getComponents(4);
			pay = Double.parseDouble(text.getText());
		}
		ArrayList<MyTableLabel> receiptLabels = receiptTable.getDataList();
		double receipt = 0;
		for(int i = 0;i<receiptLabels.size();i++){
			MyTableLabel label = receiptLabels.get(i);
			MyLabel text = (MyLabel) label.getComponents(3);
			receipt = Double.parseDouble(text.getText());
		}
		EarningVO vo = new EarningVO(receipt,pay,receipt-pay,date);
		ResultMessage result = finance.exportEarning(vo);
		if(result.isSuccess()) {
			new MyDialog("导出成功",true,controller);
		}else{
			new MyDialog(result.getErrorMessage(),true,controller);
		}

	}

}
