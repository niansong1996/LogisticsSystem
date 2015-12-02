package edu.nju.lms.presentation.components.table;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.ScrollPaneConstants;

import org.dom4j.Element;

import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyScrollPane;
import edu.nju.lms.presentation.components.MyScrollPaneUI;

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
	
	private JList<MyTableLabel> list = new JList<MyTableLabel>();

	public MyTable(Element element, UIController controller) {
		super(element, controller);
		addMouseListener(this);
		getData();
		setView();
		getVerticalScrollBar().setUI(new MyScrollPaneUI());
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	/**
	 * add a row to the table
	 * @param label: MyTableLabel
	 */
	protected void addData(MyTableLabel label) {
		data.add(label);
	}
	
	private void setView() {
		int width = 0;
		int height = 0;
		for (int i = 0; i < data.size(); i++) {
			MyTableLabel label = data.get(i);
			width = label.getWidth();
			height =  label.getHeight();
			label.setBounds(0,i*height,width, height);
			if(i%2!=0)
			label.changeGrey();
			data.set(i, label);
			list.add(label);
		}
		list.setPreferredSize(new Dimension(width, height*data.size()));
		list.setOpaque(false);
		getViewport().setView(list);
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
	
	public void my_remove(MyTableLabel component){
		list.removeAll();
		data.remove(component);
		setView();
		controller.getFrame().repaint();
	}
	
	public void my_remove(int index) {
		list.removeAll();
		data.remove(index);
		setView();
		controller.getFrame().repaint();
	}
	
	public ArrayList<MyTableLabel> getDataList(){
		return data;
	}
	public void setDataList(ArrayList<MyTableLabel> labels){
		this.data = labels;
		list.removeAll();
		setView();
		controller.getFrame().repaint();
	}

}
