package edu.nju.lms.presentation.button.buttonlistener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import edu.nju.lms.presentation.MainPanel;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.button.MainButton;

/**
 *@author tj
 *@date 2015年11月18日
 */
public class ButtonListener implements MouseListener{
	protected ArrayList<java.awt.Component> units;
	protected UIController controller;
	protected MainButton button;
	public ButtonListener(ArrayList<java.awt.Component> units,UIController controller,MainButton button){
		this.units = units;
		this.controller = controller;
		this.button = button;
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		button.setIn(true);
		
	}

	public void mouseExited(MouseEvent e) {
		button.setIn(false);
		
	}
}
