package edu.nju.lms.presentation.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import org.dom4j.Element;

import edu.nju.lms.presentation.UIController;

/**
 * When create a table, you need to override a method to initialize data
 * For example, when create a personnelTable,you need to create {@link PersonnelTable}
 * and override addData method
 * @author cuihao
 * @see MyTableLabel
 * @date 2015-11-29 23:36:18
 */
public abstract class MyTable extends MyScrollPane<MyTableLabel> implements MouseListener{

	private static final long serialVersionUID = -6295339660809296638L;

	/**
	 * list of {@link MyTableLabel} to be shown
	 */
	private ArrayList<MyTableLabel> data = new ArrayList<MyTableLabel>();

	public MyTable(Element element, UIController controller) {
		super(element, controller);
		addMouseListener(this);
		getData();
		for (int i = 0; i < data.size(); i++) {
			MyTableLabel label = data.get(i);
			label.setBounds(0,i*label.getHeight(),label.getWidth(), label.getHeight());
			getViewport().setView(label);
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
	
	public void mouseClicked(MouseEvent e) {
		controller.getFrame().repaint();
	}

	public void mouseEntered(MouseEvent e) {
		controller.getFrame().repaint();
	}

	public void mouseExited(MouseEvent e) {
		controller.getFrame().repaint();
	}

	public void mousePressed(MouseEvent e) {
		controller.getFrame().repaint();
	}

	public void mouseReleased(MouseEvent e) {
		controller.getFrame().repaint();
	}
	
	public void remove(MyTableLabel component){
		data.remove(component);
	}

}
