package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextField;

import edu.nju.lms.VO.EnumTransformer;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.PackingType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.TransportMode;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.DateChooser;
import edu.nju.lms.presentation.components.MainButton;
import edu.nju.lms.presentation.components.MyComboBox;

/**
 * @author tj
 * @date 2015年12月6日
 */
public class SaveSendListListener extends ButtonListener {
	private TransportController control;

	public SaveSendListListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getTransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MainButton button = (MainButton) units.get(21);
		MouseListener[] listeners = button.getMouseListeners();
		CreateSendListListener createListener = (CreateSendListListener)listeners[0];
		
	}
}
