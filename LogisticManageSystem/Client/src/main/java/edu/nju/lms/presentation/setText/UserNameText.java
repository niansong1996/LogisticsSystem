package edu.nju.lms.presentation.setText;

import edu.nju.lms.presentation.UIController.UIController;

/**
 *@author tj
 *@date 2015年12月20日
 */
public class UserNameText extends Text {
	
	@Override
	public String get(UIController controller) {
		return "用户名："+controller.getID();
	}

}
