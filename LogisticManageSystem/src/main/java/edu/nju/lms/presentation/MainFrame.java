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
		mainFrame
		.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setSize(1024, 768);
		
		manager.setBounds(0,0,mainFrame.getWidth(),mainFrame.getHeight());
		mainFrame.add(manager);
	}
	
}
