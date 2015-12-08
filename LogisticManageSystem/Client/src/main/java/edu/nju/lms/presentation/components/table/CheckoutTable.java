package edu.nju.lms.presentation.components.table;

import org.dom4j.Element;

import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyTextField;

/**
 *@author tj
 *@date 2015年12月7日
 */
public class CheckoutTable extends MyTable {

	public CheckoutTable(Element element, UIController controller) {
		super(element, controller);
	}

	@Override
	protected void getData() {
		// TODO Auto-generated method stub

	}
	public MyTableLabel createLabel(String expressNum,String loadType,String arrivalNum,
			String motoNum,String destination){
		MyTextField num = new MyTextField(expressNum);
		num.setSize(100,30);
		MyTextField arrival = new MyTextField(arrivalNum);
		arrival.setSize(50,30);
		MyTextField moto = new MyTextField(motoNum);
		moto.setSize(30,30);
		MyTextField desti = new MyTextField(destination);
		desti.setSize(50,30);
		MyComboBox box = new MyComboBox(element, controller);
		box.setSelectedItem(loadType);
		box.setSize(70,30);
		java.awt.Component[] component = {num,arrival,moto,desti,box};
		MyTableLabel label = new MyTableLabel(element, controller, 50, component, this);
		return label;
	}
	public void addLabel(String expressNum,String loadType,String arrivalNum,
			String motoNum,String destination){
		MyTableLabel label = createLabel(expressNum, loadType, arrivalNum, motoNum, destination);
		this.myAddLabel(label);
	}
	@Override
	protected ResultMessage deleteData(MyTableLabel label) {
		return null;
	}

}
