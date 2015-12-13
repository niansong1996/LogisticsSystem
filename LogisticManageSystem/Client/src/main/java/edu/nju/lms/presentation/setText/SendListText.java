package edu.nju.lms.presentation.setText;

import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 *@author tj
 *@date 2015年12月13日
 */
public class SendListText extends Text {
private TransportController control;
	@Override
	public String get(UIController controller) {
		this.control = controller.getTransportController();
		String result = "";
		
		return null;
	}

}
