package edu.nju.lms.presentation.setText;

import edu.nju.lms.presentation.UIController.UIController;

public class InstitutionText extends Text{

	@Override
	public String get(UIController controller) {
		String temp = controller.getID();
		return temp.substring(0, 6);
	}

}
