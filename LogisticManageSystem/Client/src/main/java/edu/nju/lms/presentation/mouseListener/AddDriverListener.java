package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.lms.VO.DriverVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.DateChooser;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyTextField;

/**
 * add driver
 * @author cuihao
 *
 */
public class AddDriverListener extends ButtonListener{

	TransportController transport;
	public AddDriverListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		transport = new TransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (transport == null)
			return;
		MyTextField name = (MyTextField) units.get(1);
		MyTextField idCard = (MyTextField) units.get(3);
		MyTextField limit = (MyTextField) units.get(2);
		MyTextField businesshall = (MyTextField) units.get(6);
		MyTextField phone = (MyTextField) units.get(4);
		DateChooser date = (DateChooser) units.get(0);
		@SuppressWarnings("unchecked")
		MyComboBox<String> sex = (MyComboBox<String>) units.get(5);
		Calendar c = date.getCalendar();
		String birth = c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.DATE);
		DriverVO driver = new DriverVO("", name.getText(), birth, idCard.getText(), phone.getText(),
				sex.getSelectedIndex(), limit.getText(), businesshall.getText());
		DriverVO finalDriver = transport.addDriver(driver);
		ResultMessage result = transport.saveDriverInfor(finalDriver);
		if (result.isSuccess()) {
			new MyDialog("addSuccess");
		} else {
			new MyDialog(result.getErrorMessage(), true);
		}
	}

}
