package edu.nju.lms.presentation.components;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Element;

import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.mouseListener.PasswordFieldListener;

/**
 * @author tj
 * @date 2015年11月19日
 */
public class MyPasswordField extends JPasswordField {

	private static final long serialVersionUID = -5174112793404643576L;
	private int x;
	private int y;
	private int h;
	private int w;
	private TexturePaint texture;
	private BufferedImage img;
	private boolean isIn;

	public MyPasswordField(Element text, UIController controller) {
		w = Integer.parseInt(text.attributeValue("w"));
		h = Integer.parseInt(text.attributeValue("h"));
		x = Integer.parseInt(text.attributeValue("x"));
		y = Integer.parseInt(text.attributeValue("y"));
		setBounds(x, y, w, h);
		drawPic();
		this.addFocusListener(new PasswordFieldListener(this));
	}

	public void paintComponent(Graphics g) {
		// 先画背景
		Graphics2D g2 = (Graphics2D) g;
		try {
			if (isIn) {
				img = ImageIO.read(new FileInputStream("src/main/resources/pictures/textfield1.png"));
			} else {
				img = ImageIO.read(new FileInputStream("src/main/resources/pictures/textfield.png"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Rectangle rect = new Rectangle(0, 0, getWidth(), getHeight());
		texture = new TexturePaint(img, rect);
		g2.setPaint(texture);
		g.fillRect(0, 0, getWidth(), getHeight());
		// 然后画控件，不然控件内容就被背景覆盖了
		super.paintComponent(g);
	}

	public void setIn(boolean b) {
		this.isIn = b;
	}
	
	private void drawPic(){
		setOpaque(false);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setFont(new Font("微软雅黑", Font.ITALIC, 23));
		try {
			img = ImageIO.read(new FileInputStream("src/main/resources/pictures/textfield.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Rectangle rect = new Rectangle(0, 0, getWidth(), getHeight());
		texture = new TexturePaint(img, rect);
	}
}
