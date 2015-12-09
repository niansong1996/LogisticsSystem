package edu.nju.lms.presentation.components;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import edu.nju.lms.presentation.config.ConfigReader;
import edu.nju.lms.presentation.config.FrameConfig;

/**
 * @author tj
 * @date 2015年11月23日
 */
public class MyDialog extends JFrame implements Runnable {

	private static final long serialVersionUID = 17645107890724600L;
	private FrameConfig config;
	private String info;
	private boolean is_str = false;
	private Dimension screenSize;
	public MyDialog(String info) {
		this.info = info;
		initialize();
		Thread t = new Thread(this);
		t.start();
	}

	/**
	 * show any String
	 * @param info
	 * @param is_str
	 */
	public MyDialog(String info, boolean is_str) {
		this.info = info;
		this.is_str = is_str;
		initialize();
		Thread t = new Thread(this);
		t.start();
	}

	@SuppressWarnings("restriction")
	public void initialize() {
		setUndecorated(true);
		ConfigReader reader = new ConfigReader();
		config = reader.readFrame("MyDialog");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(config.getWidth(), config.getHeight());

		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - config.getWidth()) / 2 + 430,
				(screenSize.height - config.getHeight()) / 2 + 300);
		setVisible(true);
		com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.6f);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Image image;
		try {
			if (is_str) {
				g.setFont(new Font("微软雅黑", Font.BOLD, 23));
				g.drawString(info, 23, 23);
				setLocation((screenSize.width - config.getWidth()) / 2 -200,
				(screenSize.height - config.getHeight()) / 2 +200);
				setSize(700,44);
			} else {
				image = ImageIO.read(new FileInputStream("pictures/" + info + ".png"));
				g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		int time = 100;
		for (int i = time; i > 0; i--) {
			com.sun.awt.AWTUtilities.setWindowOpacity(this, (float) (i * 0.01));
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dispose();
	}

}
