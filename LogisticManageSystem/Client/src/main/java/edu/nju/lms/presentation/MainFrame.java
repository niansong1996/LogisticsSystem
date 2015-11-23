package edu.nju.lms.presentation;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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
	MainPanel panel;
	private int winX,winY;
	private int oldX,oldY;
	private int x,y;
	private int tempX,tempY;
	public MainFrame() {
		initialize();
	}
	public MainFrame(String panelName) {
		this.panelName = panelName;
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
		setUndecorated(true);
		MyListener listener = new MyListener();
		addMouseMotionListener(listener);
		addMouseListener(listener);
	}
	
	public void changeTo(String panel,UIController controller) {
		if(panel.equals(panelName)){
			return;
		}
		ConfigReader reader = new ConfigReader();
		PanelConfig panelConfig = reader.readPanel(panel);
		MainPanel mainPanel = new MainPanel(panelConfig,controller);
		setPanel(mainPanel);
		getContentPane().setVisible(false);
		setContentPane(mainPanel);
		mainPanel.setVisible(true);
		repaint();
	}
	public MainPanel getPanel() {
		return panel;
	}
	public void setPanel(MainPanel panel) {
		this.panel = panel;
	}
	class MyListener implements MouseListener,MouseMotionListener{

		public void mouseDragged(MouseEvent e) {
			Point point = e.getPoint();
			Rectangle rec = getBounds();
					
			winX = (int)rec.getX();
			winY = (int)rec.getY();		
			x = (int)point.getX();
			y = (int)point.getY();		
			tempX = x - oldX;
			tempY = y - oldY;		
			
			setLocation(winX + tempX, winY + tempY);	
		}

		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			Rectangle rec = getBounds();
			Point point = e.getPoint();		
			tempX = (int)point.getX();
			tempY = (int)point.getY();
			oldX = (int)point.getX();
			oldY = (int)point.getY();
			
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
}
