package edu.nju.lms.presentation;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.lms.presentation.config.ConfigReader;
import edu.nju.lms.presentation.config.FrameConfig;

/**
 *@author tj cuihao
 *@date 2015-11-18 14:34:59
 */
public class MainFrame extends JFrame{
	FrameConfig config;
	public MainFrame() {
		initialize();
	}
	public MainFrame(String panelName) {
		initialize();
	}
	private void initialize() {
		ConfigReader reader = new ConfigReader();
		config = reader.readFrame("MainFrame");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(config.getWidth(),config.getHeight());
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - config.getWidth()) / 2,(screenSize.height-config.getHeight())/2);
		setVisible(true);
	}
	
}
