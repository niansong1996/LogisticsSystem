package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.DriverVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
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
		MyTextField businesshall = (MyTextField) units.get(5);
		MyTextField phone = (MyTextField) units.get(4);
		if(name.getText().isEmpty()||idCard.getText().isEmpty()||limit.getText().isEmpty()||
				businesshall.getText().isEmpty()||phone.getText().isEmpty()){
			new MyDialog("incomplete",controller);
		}
		DateChooser date = (DateChooser) units.get(0);
		@SuppressWarnings("unchecked")
		MyComboBox<String> sex = (MyComboBox<String>) units.get(6);
		Calendar c = date.getCalendar();
		String str1 = (c.get(Calendar.MONTH)+1)>9?"":"0";
		String str2 = c.get(Calendar.DATE)<10?"1":"0";
		String birth = c.get(Calendar.YEAR) + "-" +str1+(c.get(Calendar.MONTH) + 1) + "-" +str2+ c.get(Calendar.DATE);
		DriverVO driver = new DriverVO("", name.getText(), birth, idCard.getText(), phone.getText(),
				sex.getSelectedIndex(), limit.getText(), businesshall.getText());
		DriverVO finalDriver = transport.addDriver(driver);
		ResultMessage result = transport.saveDriverInfor(finalDriver);
		if (result.isSuccess()) {
			new MyDialog("addSuccess",controller);
		} else {
			new MyDialog(result.getErrorMessage(), true,controller);
		}
	}

}
