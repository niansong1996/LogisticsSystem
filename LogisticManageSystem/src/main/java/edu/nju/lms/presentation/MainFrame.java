package edu.nju.lms.presentation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class MainFrame {

	private JFrame mainFrame;
	private ManagerPanel manager;
	public MainFrame(){
       initComponents();
       setParameters();
	   mainFrame.setVisible(true);
	}
	
	private void initComponents(){
		mainFrame = new JFrame();
		manager = new ManagerPanel();
	}
	
	private void setParameters(){
		int width = 1080;
		int height= 720;
		mainFrame
		.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setSize(width, height);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		
		mainFrame.setLocation((screenSize.width - width) / 2,(screenSize.height-height)/2);
		
		manager.setBounds(0,0,mainFrame.getWidth(),mainFrame.getHeight());
		mainFrame.getContentPane().add(manager);
	}
	
}
