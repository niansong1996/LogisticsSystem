package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MainButton;

/**
 * General <b>MouseListener</b> used to change picture of the button
 * @author tj
 * @date 2015年11月18日
 */
public abstract class ButtonListener implements MouseListener{
	protected ArrayList<java.awt.Component> units;
	protected UIController controller;
	protected MainButton button;
	public ButtonListener(ArrayList<java.awt.Component> units,UIController controller,Component button){
		this.units = units;
		this.controller = controller;
		this.button = (MainButton)button;
	}

	public void mouseClicked(MouseEvent e) {
		button.setIn(false);
		button.setPressed(true);
		controller.getFrame().repaint();
	}

	public void mousePressed(MouseEvent e) {
		button.setIn(false);
		button.setPressed(true);
		controller.getFrame().repaint();
	}

	abstract public void mouseReleased(MouseEvent e);

	public void mouseEntered(MouseEvent e) {
		button.setIn(true);
		controller.getFrame().repaint();
	}

	public void mouseExited(MouseEvent e) {
		button.setIn(false);
		button.setPressed(false);
		controller.getFrame().repaint();
	}
}
