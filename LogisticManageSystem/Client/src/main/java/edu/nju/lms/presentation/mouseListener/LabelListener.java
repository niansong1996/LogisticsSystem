package edu.nju.lms.presentation.mouseListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.nju.lms.VO.EnumTransformer;
import edu.nju.lms.data.ListType;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyLabel;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.config.ConfigReader;
import edu.nju.lms.presentation.config.PanelConfig;
import edu.nju.lms.presentation.frame.MainPanel;

/**
 *@author tj
 *@date 2015年12月11日
 */
public class LabelListener implements MouseListener{
	private MyTableLabel label;
	private UIController controller;
	private MainPanel panel;
	public LabelListener(MyTableLabel label,UIController controller){
		this.label = label;
		this.controller = controller;
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2){
			this.panel = controller.getFrame().getPanel();
			//get the list type 
			MyLabel typeLabel = (MyLabel) label.getComponents(0);
			String str = typeLabel.getText();
			//transform the Chinese to panel name
			ListType t = EnumTransformer.str2ListType(str);
			String type = t.toString();
			//read configure of the new panel
			ConfigReader reader = new ConfigReader();
			PanelConfig panelConfig = reader.readPanel(type);
			//create new panel
			MainPanel mainPanel = new MainPanel(panelConfig,controller);
			mainPanel.setVisible(true);
			panel.add(mainPanel);
			panel.repaint();
		}	
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
