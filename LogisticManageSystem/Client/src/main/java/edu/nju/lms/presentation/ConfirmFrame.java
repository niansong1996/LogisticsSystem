package edu.nju.lms.presentation;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.lms.presentation.components.MainButton;
import edu.nju.lms.presentation.config.ConfigReader;
import edu.nju.lms.presentation.config.FrameConfig;

public class ConfirmFrame extends MainFrame {
	
	private static final long serialVersionUID = -7548510958161064852L;
	
	private String confirmMessage;
	private int width;
	private int height;
	private JPanel panel;
	private boolean isClicked = false;
	private boolean isConfirm = false;
	private MainButton confirm;
	private MainButton cancel;
	
	public ConfirmFrame() {
		this("");
	}
	
	public ConfirmFrame(String message) {
		super();
		this.confirmMessage = message;
		initializeFrame();
		initializePanel();
		initializeLabel();
		initializeButton();
	}
	
	public boolean isConfirm(){
		while(!isClicked){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		this.dispose();
		return isConfirm;
	}
	
	private void initializeFrame() {
		ConfigReader reader = new ConfigReader();
		FrameConfig config = reader.readFrame("ConfirmFrame");
		width = config.getWidth();
		height = config.getHeight();
		setResizable(false);
		setSize(width,height);
		setAutoRequestFocus(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - width) / 2,(screenSize.height-height)/2);
		setUndecorated(true);
		setVisible(true);
	}
	
	private void initializePanel() {
		panel = new JPanel(){
			private static final long serialVersionUID = 6241281467240637572L;
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(new ImageIcon("pictures/confirmFrame.png").getImage(),0,0, getWidth(), getHeight(), this);
			}
		};
		panel.setBounds(0, 0, getWidth(), getHeight());
		getContentPane().add(panel);
		panel.setLayout(null);
	}
	
	private void initializeButton() {
		confirm = new MainButton("confirm");
		confirm.setBounds(75, 155, 112, 34);
		confirm.setVisible(true);
		confirm.addMouseListener(new ConfirmDialogListener());
		cancel = new MainButton("cancel");
		cancel.setBounds(215, 155, 112, 34);
		cancel.setVisible(true);
		cancel.addMouseListener(new CancelDialogListener());
		panel.add(confirm);
		panel.add(cancel);
	}
	
	private void initializeLabel() {
	}
	
	class ConfirmDialogListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {
			confirm.setIn(true);
			confirm.repaint();
		}

		public void mouseExited(MouseEvent e) {
			confirm.setIn(false);
			confirm.repaint();
		}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {
			isClicked = true;
			isConfirm = true;
		}
		
	}
	
	class CancelDialogListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {
			cancel.setIn(true);
			cancel.repaint();
		}

		public void mouseExited(MouseEvent e) {
			cancel.setIn(false);
			cancel.repaint();
		}

		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {
			isClicked = true;
			isConfirm = false;
		}
	}
	
	public static void main(String[] args) {
		ConfirmFrame frame = new ConfirmFrame("hahahahah");
		System.out.println(frame.isConfirm());
	}
}
