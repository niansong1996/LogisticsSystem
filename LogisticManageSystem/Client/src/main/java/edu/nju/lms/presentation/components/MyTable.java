package edu.nju.lms.presentation.components;

import java.util.ArrayList;
import org.dom4j.Element;

import edu.nju.lms.presentation.UIController;

public abstract class MyTable extends MyScrollPane<MyTableLabel> {

	private static final long serialVersionUID = -6295339660809296638L;

	/**
	 * list of {@link MyTableLabel} to be shown
	 */
	private ArrayList<MyTableLabel> data = new ArrayList<MyTableLabel>();

	public MyTable(Element element, UIController controller) {
		super(element, controller);
		getData();
		for (MyTableLabel label: data) {
			addItem(label);
		}
	}
	
	/**
	 * add a row to the table
	 * @param label: MyTableLabel
	 */
	protected void addData(MyTableLabel label) {
		data.add(label);
	}
	
	/**
	 * initialize ArrayList<MyTableLabel> data
	 * @see# addData
	 */
	protected abstract void getData();

}
