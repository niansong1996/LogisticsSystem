package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import edu.nju.lms.VO.EnumTransformer;
import edu.nju.lms.VO.SalaryStrategyVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyLabel;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.components.table.SalaryStrategyTable;

/**
 * @author tj
 * @date 2015年11月26日
 */
public class SaveSalaryStrategyButtonListener extends ButtonListener {
	private SalaryStrategyTable table;

	public SaveSalaryStrategyButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		table = (SalaryStrategyTable) units.get(0);
	}

	public void mouseReleased(MouseEvent e) {
		FinanceController control = controller.getFinanceController();
		ResultMessage result = null;
		ArrayList<MyTableLabel> labels = table.getDataList();
		boolean inComplete = false;
		for (int i = 0; i < labels.size(); i++) {
			MyTableLabel label = labels.get(i);
			MyLabel typeLabel = (MyLabel) label.getComponents(0);
			// 为了创建vo方便把一些信息放在了string数组里
			String[] info = new String[3];
			for (int j = 2; j < 5; j++) {
				JTextField f = (JTextField) label.getComponents(j);
				// 如果信息不完整
				if (f.getText().isEmpty()) {
					inComplete = true;
				}
				// 如果填的不是数字
				if (!Numeric.isNumeric(f.getText())) {
					inComplete = true;
				}
				info[j - 2] = f.getText();
			}
			// 这样可以只弹出一个对话框...
			if (inComplete) {
				new MyDialog("信息格式有误", true);
				return;
			}
			// 把人员种类中文转成英文
			String type = EnumTransformer.str2PersonType(typeLabel.getText()).toString();
			SalaryStrategyVO vo = new SalaryStrategyVO(type, Double.parseDouble(info[0]), Double.parseDouble(info[2]),
					Double.parseDouble(info[1]));
			//先看看是不是第一次设置薪水策略
			if (control.findSalaryStrategy(EnumTransformer.str2PersonType(typeLabel.getText())) != null) {
				result = control.updateSalaryStrategy(vo);
			}else{
				result = control.addSalaryStrategy(vo);
			}
			if (result.isSuccess()) {
				new MyDialog("保存成功！", true);
			} else {
				new MyDialog(result.getErrorMessage(), true);
			}
		}
	}
}
