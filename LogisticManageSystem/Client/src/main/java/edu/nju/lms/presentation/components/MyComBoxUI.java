package edu.nju.lms.presentation.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class MyComBoxUI extends BasicComboBoxUI{
	/**
	 * scroll button
	 */
	JButton button;
	/**
	 * something I don't know.
	 */
	private boolean boundsLight = false;
	
	public MyComBoxUI() {
		super();
	}
	
	/**
	 * get button
	 */
	@Override
	protected JButton createArrowButton(){
		button = new JButton();
		button.setIcon(new ImageIcon("pictures/units/combobutton.png"));
		button.setRolloverEnabled(true);
		button.setRolloverIcon(new ImageIcon("pictures/units/combobutton1.png"));
		button.setRolloverSelectedIcon(new ImageIcon("pictures/units/combobutton2.png"));
		button.setBorder(null);
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		return button;
	}
	
	/**
	 * paint button
	 */
	public void paint(Graphics g, JComponent c) {
		hasFocus = comboBox.hasFocus();
		Graphics2D g2 = (Graphics2D) g;
		if (!comboBox.isEditable()) {
			Rectangle r = rectangleForCurrentValue();
			paintCurrentValueBackground(g2, r, hasFocus);
			paintCurrentValue(g2, r, hasFocus);
		}
		if (comboBox.isPopupVisible()) {
			button.setIcon(new ImageIcon("pictures/units/combobutton1.png"));
		} else {
			button.setIcon(new ImageIcon("pictures/units/combobutton.png"));
		}
	}
	
	/**
	 * paint text
	 */
	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
		Font oldFont = comboBox.getFont();
		comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 21));

		super.paintCurrentValue(g, bounds, hasFocus);
		comboBox.setFont(oldFont);
	}

	public Dimension getPreferredSize(JComponent c) {
		return super.getPreferredSize(c);
	}

	public boolean isBoundsLight() {
		return boundsLight;
	}

	public void setBoundsLight(boolean boundsLight) {
		this.boundsLight = boundsLight;
	}

	/**
	 * create scroll pane
	 */
	protected ComboPopup createPopup() {
		ComboPopup popup = new BasicComboPopup(comboBox) {
			private static final long serialVersionUID = 7869205825443338959L;

			protected JScrollPane createScroller() {
				MyScollpane<String> sp = new MyScollpane<String>(list);
				sp.setFont(new Font("微软雅黑", Font.PLAIN, 21));
				sp.setHorizontalScrollBar(null);
				return sp;
			}

			/**
			 * paint border
			 */
			public void paintBorder(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.DARK_GRAY);
				g2.drawRoundRect(0, -button.getHeight(), getWidth() - 1, getHeight() + button.getHeight() - 1, 0, 0);
			}
		};
		return popup;
	}
}
