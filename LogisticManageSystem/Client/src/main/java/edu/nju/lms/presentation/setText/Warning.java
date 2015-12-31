package edu.nju.lms.presentation.setText;

import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 * show cordon automatially
 * @author cuihao
 * 2015-12-30 11:35:17
 */
public class Warning extends Text{

	@Override
	public String get(UIController controller) {
		String institution = controller.getID().substring(0, 6);
		WarehouseController c = controller.getWarehouseController();
		double warning = c.getCordon(institution);
		return warning+"";
	}

}
