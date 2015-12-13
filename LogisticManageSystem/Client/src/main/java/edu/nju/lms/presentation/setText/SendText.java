package edu.nju.lms.presentation.setText;

import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 * @author tj
 * @date 2015年12月13日
 */
public class SendText extends Text {
	private ListController control;
	private String id;

	public SendText(String id) {
		this.id = id;
	}

	@Override
	public String get(UIController controller) {
		String result = "";

		return null;
	}

}
