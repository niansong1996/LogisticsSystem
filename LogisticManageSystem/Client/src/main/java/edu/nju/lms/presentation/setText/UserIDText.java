package edu.nju.lms.presentation.setText;

import edu.nju.lms.presentation.UIController.UIController;

public class UserIDText extends Text{

	@Override
	public String get(UIController controller) {
		return controller.getID();
	}

}
