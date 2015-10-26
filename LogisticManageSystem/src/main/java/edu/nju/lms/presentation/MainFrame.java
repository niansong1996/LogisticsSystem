package edu.nju.lms.presentation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.lms.businessLogicService.UserblService;
import edu.nju.lms.presentation.panel.AdminPanel;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class MainFrame {
	private UserblService userbl;
	private JFrame mainFrame;
	private AdminPanel admin;
	public MainFrame(UserblService userbl){
	   this.userbl = userbl;
       initComponents();
       setParameters();
	   mainFrame.setVisible(true);
	}
	
	private void initComponents(){
		mainFrame = new JFrame();
		admin = new AdminPanel(userbl);
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
		
		admin.setBounds(0,0,mainFrame.getWidth(),mainFrame.getHeight());
		mainFrame.getContentPane().add(admin);
	}
	
}
