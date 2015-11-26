package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.PriceStrategyVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyDialog;

/**
 * @author tj
 * @date 2015年11月26日
 */
public class SaveFreightStrategyButtonListener extends ButtonListener {

	public SaveFreightStrategyButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		// TODO Auto-generated constructor stub
	}

	public void mouseReleased(MouseEvent e) {
		FinanceController finance = controller.getFinanceController();
		if (finance != null) {
			JTextField pricef = (JTextField) units.get(0);
			String price = pricef.getText();
			if(price.isEmpty()){
				MyDialog d = new MyDialog("incomplete");
				return;
			}
			// MyDialog result = new MyDialog("修改后的经济、标准和次晨快递之比为：",true);
			ResultMessage re = finance.updatePriceStrategy(Double.parseDouble(price));
			PriceStrategyVO vo = finance.findPriceStrategy();
			if (re.isSuccess()) {
				MyDialog result = new MyDialog(
						"修改后的经济、标准和次晨快递之比为：" + vo.getEconomic() + ":" + vo.getStandard() + ":" + vo.getExpress(), true);
			} else {
				MyDialog result = new MyDialog(re.getErrorMessage());
			}
		}
	}
}
