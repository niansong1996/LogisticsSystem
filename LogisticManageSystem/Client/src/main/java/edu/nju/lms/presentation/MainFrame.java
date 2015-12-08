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
 * Main frame of client
 *@author tj cuihao
 *@date 2015-11-18 14:34:59
 */
public class MainFrame extends JFrame{

	private static final long serialVersionUID = 3444411286661024461L;
	
	/**
	 * configure of the frame
	 */
	private FrameConfig config;
	private String panelName ;
	/**
	 * panel in the frame
	 */
	private MainPanel panel;
	
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
		//read configure
		ConfigReader reader = new ConfigReader();
		config = reader.readFrame("MainFrame");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(config.getWidth(),config.getHeight());
		//in the middle
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - config.getWidth()) / 2,(screenSize.height-config.getHeight())/2);
		setUndecorated(true);
		//drag listener
		MyListener listener = new MyListener();
		addMouseMotionListener(listener);
		addMouseListener(listener);
	}
	
	/**
	 * Change the panel in the frame
	 * @param panel to change
	 * @param UIController
	 */
	public void changeTo(String panel,UIController controller) {
		if(panel.equals(panelName)){
			return;
		}
		//read configure of the new panel
		ConfigReader reader = new ConfigReader();
		PanelConfig panelConfig = reader.readPanel(panel);
		//create new panel
		MainPanel mainPanel = new MainPanel(panelConfig,controller);
		setPanel(mainPanel);
		//remove old panel
		getContentPane().setVisible(false);
		//set new panel
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
	
	/**
	 * 
	 * frame drag listener
	 * @author tj
	 *
	 */
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
			
		}

		public void mouseClicked(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			Point point = e.getPoint();		
			tempX = (int)point.getX();
			tempY = (int)point.getY();
			oldX = (int)point.getX();
			oldY = (int)point.getY();
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}
		
	}
}
