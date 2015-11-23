package edu.nju.lms.presentation.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.dom4j.Element;

import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.config.ConfigReader;
import edu.nju.lms.presentation.config.FrameConfig;

/**
 * @author tj
 * @date 2015年11月23日
 */
public class MyDialog extends JFrame implements Runnable {
	private FrameConfig config;
	private String info;

	public MyDialog(String info) {
		this.info = info;
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

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - config.getWidth()) / 2+430 ,(screenSize.height - config.getHeight()) / 2+300);
		setVisible(true);
		com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.6f);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Image image;
		try {
			image = ImageIO.read(new FileInputStream("pictures/" + info + ".png"));
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		int time = 100;
		for (int i = time; i >0; i--) {
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
