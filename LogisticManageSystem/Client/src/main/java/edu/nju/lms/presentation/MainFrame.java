package edu.nju.lms.presentation;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import edu.nju.lms.presentation.config.ConfigReader;
import edu.nju.lms.presentation.config.FrameConfig;
import edu.nju.lms.presentation.config.PanelConfig;

/**
 *@author tj cuihao
 *@date 2015-11-18 14:34:59
 */
public class MainFrame extends JFrame{
	FrameConfig config;
	String panelName ;
	public MainFrame() {
		initialize();
	}
	public MainFrame(String panelName) {
		this.panelName = panelName;
		initialize();
	}
	private void initialize() {
		System.out.println("initialize");
		ConfigReader reader = new ConfigReader();
		config = reader.readFrame("MainFrame");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(config.getWidth(),config.getHeight());
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - config.getWidth()) / 2,(screenSize.height-config.getHeight())/2);
		setVisible(true);
	}
	
	public void changeTo(String panel,UIController controller) {
		ConfigReader reader = new ConfigReader();
		PanelConfig panelConfig = reader.readPanel(panel);
		MainPanel mainPanel = new MainPanel(panelConfig,controller);
		getContentPane().setVisible(false);
		getContentPane().add(mainPanel);
		getContentPane().setVisible(true);
		repaint();
	}
	
}
