package edu.nju.lms.presentation.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import org.dom4j.Element;

/**
 * general table label
 * a table is composed of a {@link MyTable} extends {@link MyScrollPane} 
 * and many table labels, this is a general table label including {@link MyCheckBox}
 * , {@link MyTextField}, and {@link MainButton}
 * @author cuihao
 * @date 2015-11-29 23:23:49
 */
public class MyTableLabel extends JLabel implements MouseListener{

	private static final long serialVersionUID = 420418378988671847L;
	
	/**
	 * width of the label
	 */
	private int width;
	
	/**
	 * height of the label
	 */
	private int height;
	
	/**
	 * the label includes many components including {@link MyCheckBox}
     * {@link MyTextField}, and {@link MainButton}
	 */
	private java.awt.Component[] components;
	
	/**
	 * path of picture background (white default)
	 */
	private String picPath = "pictures/white.png";
	
	/**
	 * delete button of the label
	 */
	MainButton button = null;
	
	/**
	 * the color of the label
	 */
	public static boolean isWhite;
	
	/**
	 * a reference used in button listener
	 * @warning table might be uninitialized 
	 */
	private MyTable table;

	/**
	 * @param element of the <b>table</b>
	 * @param height of this label
	 * @param components this label, must be components
	 * @param table which the label belongs to. This parameter is not a good design
	 */
	public MyTableLabel(Element element, int height, java.awt.Component[] components, MyTable table) {
		setLayout(null);
		width = Integer.parseInt(element.attributeValue("w"));
		this.height = height;
		this.components = components;
		this.table = table;
		initializeComponents();
		setPreferredSize(new Dimension(width, height));
		addMouseListener(this);
	}
	
	/**
	 * add check box and button additionally
	 */
	private void initializeComponents() {
		int column = width/(components.length + 2);
		MyCheckBox check = new MyCheckBox("");
		check.setBounds((column-30)/2, (height-30)/2, 20, 20);
		add(check);
		for(int i = 1; i <= components.length; i++) {
			java.awt.Component component = components[i-1];
			component.setBounds(i*column+column/8, height/8, column*3/4, height*3/4);
			add(component);
		}
		button = new MainButton("delete");
		button.setBounds((components.length+1)*column+column/8, height/8, column*3/4, height*3/4);
		button.setVisible(false);
		button.addMouseListener(new tableDeleteListener(table, this));
		add(button);
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(new ImageIcon(picPath).getImage(),0,0,this.getWidth(), this.getHeight()+20,this);
	}

	public void mouseClicked(MouseEvent e) {
		repaint();
	}

	public void mouseEntered(MouseEvent e) {
		repaint();
	}

	public void mouseExited(MouseEvent e) {
		changeWhite();
		showButton(false);
		repaint();
	}

	public void mousePressed(MouseEvent e) {
		changeGrey();
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
		showButton(true);
		repaint();
	}
	
	/**
	 * get component in the label
	 * @param index
	 * @return java.awt.component
	 */
	public java.awt.Component getComponents(int index){
		return components[index];
	}
	
	/**
	 * get column of the component
	 * @return length of components
	 */
	public int getColumnNum(){
		return components.length;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	private void changeGrey(){
		picPath = "pictures/addPath.png";
	}
	
	private void changeWhite(){
		picPath = "pictures/white.png";
	}
	
	private void showButton(boolean isShow) {
		button.setVisible(isShow);
	}
	
	/**
	 * delete button listener
	 * @author cuihao
	 * @date 2015-11-29 23:35:13
	 */
	class tableDeleteListener implements MouseListener{

		MyTable table;
		MyTableLabel label;
		public tableDeleteListener(MyTable table, MyTableLabel label) {
			this.table = table;
			this.label = label;
		}
		
		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
			table.remove(label);
			table.repaint();
		}
		
	}

}
