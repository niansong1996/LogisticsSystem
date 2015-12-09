package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTextField;

import edu.nju.lms.VO.EnumTransformer;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.data.PackingType;
import edu.nju.lms.data.TransportMode;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.DateChooser;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.MyLabel;

/**
 * @author tj
 * @date 2015年12月6日
 */
public class CreateSendListListener extends ButtonListener {
	private TransportController control;
	private SendVO vo;

	public CreateSendListListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.control = controller.getTransportController();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// get base information
		ArrayList<String> baseInfo = new ArrayList<String>();
		for (int i = 5; i < 13; i++) {
			JTextField field = (JTextField) units.get(i);
			if(field.getText().isEmpty()){
				new MyDialog("incomplete");
				return;
			}
			baseInfo.add(field.getText());
			field.setText("");
		}
		//city
		MyComboBox<?> cb = (MyComboBox<?>) units.get(3);
		String receiverCity = (String) cb.getSelectedItem();
		MyComboBox<?> combo = (MyComboBox<?>) units.get(4);
		String senderCity = (String) combo.getSelectedItem();
		// transform date to string
		DateChooser dateChooser = (DateChooser) units.get(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(dateChooser.getCalendar());
		// packType
		MyComboBox<?> box = (MyComboBox<?>) units.get(1);
		PackingType packType = EnumTransformer.str2PackType((String) box.getSelectedItem());
		// transMode
		MyComboBox<?> box1 = (MyComboBox<?>) units.get(2);
		TransportMode transMode = EnumTransformer.str2TransMode((String) box1.getSelectedItem());
		// expressNum number weight volume inName size
		String[] other = new String[6];
		for (int i = 13; i < 19; i++) {
			JTextField field = (JTextField) units.get(i);
			other[i - 13] = field.getText();
		}
		// create SendVo
		boolean isNumeric = true;
		for(int i =1;i<3;i++){
			if(!Numeric.isNumeric(other[i])){
				isNumeric = false;
				break;
			}
		}
		
		if(!isNumeric){
			new MyDialog("信息格式不正确",true);
			return;
		}
		vo = new SendVO(other[0], null, baseInfo, senderCity,receiverCity,Integer.parseInt(other[1]), Double.parseDouble(other[2]),
				Double.parseDouble(other[3]), other[4], packType, transMode, 0, 0, date);
		completeInfo(control.createSendList(vo));
	}

	public void completeInfo(SendVO result) {
		MyLabel priceLabel = (MyLabel) units.get(19);
		priceLabel.setText(result.getPrice() + "");
		MyLabel timeLabel = (MyLabel) units.get(20);
		timeLabel.setText(result.getTime() + "");
	}

	public SendVO getVo() {
		return vo;
	}
}
