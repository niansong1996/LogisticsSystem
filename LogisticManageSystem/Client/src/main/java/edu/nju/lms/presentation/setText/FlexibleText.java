package edu.nju.lms.presentation.setText;

import java.math.BigDecimal;

import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 *@author tj
 *@date 2015年12月17日
 */
public class FlexibleText extends Text {
	private WarehouseController control;
	@Override
	public String get(UIController controller) {
		this.control = controller.getWarehouseController();
		double f = 1.0*control.getFlexibleRowNum()/control.getTotalRowNum()*100;
		BigDecimal b = new BigDecimal(f);
		double f1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return "机动区："+f1+"%";
	}

}
