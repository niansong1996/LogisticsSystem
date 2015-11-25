package edu.nju.lms.presentation.components;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import org.dom4j.Element;

import edu.nju.lms.presentation.UIController;

/**
 * my scrollpane
 * @author cuihao
 * @date 2015-11-25 19:23:54
 * @param <T> components in the scrollpane
 */
public class MyScollpane<T> extends JScrollPane{

	private static final long serialVersionUID = -2221225508091244689L;
	private JList<T> list = new JList<T>();
	private DefaultListModel<T> model = new DefaultListModel<T>();

	public MyScollpane(Element element, UIController controller) {
		this();
		setBounds(Integer.parseInt(element.attributeValue("x")), Integer.parseInt(element.attributeValue("y")),
				Integer.parseInt(element.attributeValue("w")), Integer.parseInt(element.attributeValue("h")));
	}
	
	public MyScollpane(){
		list.setModel(model);
        getViewport().setView(list);
        getVerticalScrollBar().setUI(new MyScrollPaneUI());
	}
		
	public JList<T> getList() {
		return list;
	}

	public void setList(JList<T> list) {
		this.list = list;
	}
	
	public void addItem(T x){
		model.addElement(x);
	}
	
	public void removeItem(T x){
		model.removeElement(x);
	}
	
	public void removeItem(int i){
		model.remove(i);
	}
	
//	public static void main(String[] args){
//		JFrame frame = new JFrame("test");
//		frame.setTitle("ScrollBar Demo");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 200);
//        frame.setAlwaysOnTop(true);
//        MyScollpane<String> s = new MyScollpane<String>();
//        frame.getContentPane().add(s, java.awt.BorderLayout.CENTER);
//        frame.setVisible(true);
//	}
}
