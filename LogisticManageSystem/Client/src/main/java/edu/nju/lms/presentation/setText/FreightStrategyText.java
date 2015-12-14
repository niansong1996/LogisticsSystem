package edu.nju.lms.presentation.setText;

import edu.nju.lms.VO.PriceStrategyVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 *@author tj
 *@date 2015年12月14日
 */
public class FreightStrategyText extends Text {

	@Override
	public String get(UIController controller) {
		String result="";
		FinanceController control = controller.getFinanceController();
		PriceStrategyVO vo = control.findPriceStrategy();
		return vo.getStandard()+"";
	}

}
