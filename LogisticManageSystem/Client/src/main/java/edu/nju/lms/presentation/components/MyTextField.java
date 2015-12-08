package edu.nju.lms.presentation.components;

import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Element;

import edu.nju.lms.presentation.UIController;

/**
 * @author tj
 * @date 2015年11月19日
 */
public class MyTextField extends JTextField {
	private int x;
	private int y;
	private int h;
	private int w;
	private TexturePaint texture;
	private BufferedImage img;
	Element text;
	private UIController controller;
	public MyTextField(Element text, UIController controller) {
		super();
		this.text = text;
		w = Integer.parseInt(text.attributeValue("w"));
		h = Integer.parseInt(text.attributeValue("h"));
		x = Integer.parseInt(text.attributeValue("x"));
		y = Integer.parseInt(text.attributeValue("y"));
		setBounds(x, y, w, h);
		this.controller = controller;
		this.setFocusable(true);
		drawPic();
		setInitial();
	}

	public MyTextField(String text) {
		super();
		setText(text);
		setHorizontalAlignment(JTextField.CENTER);
		drawPic();
		setFont(new Font("微软雅黑", Font.PLAIN, 16));
		setEditable(false);
	}
	public MyTextField(){
		super();
	}
    public void setInitial(){
    	String type = text.attributeValue("textType");
    	String[] infos = type.split(";");
    	SetText myset = new SetText();
    	if(infos[0].equals("null")){
    		return;
    	}else if(infos[0].equals("salaryStrategy")||infos[0].equals("freightStrategy")){
    		this.setText(myset.mySetText(type,controller.getFinanceController()));
    	}else if(infos[0].equals("warningline")){
    		this.setText(myset.mySetText(type, controller.getWarehouseController()));
    	}
    }
	public void paintComponent(Graphics g) {
		// 先画背景
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(texture);
		g.fillRect(0, 0, getWidth(), getHeight());
		// 然后画控件，不然控件内容就被背景覆盖了
		super.paintComponent(g);
	}
	
	public void drawPic(){
		setOpaque(false);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setFont(new Font("微软雅黑", Font.ITALIC, 23));
		try {
			img = ImageIO.read(new FileInputStream("pictures/textfield.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Rectangle rect = new Rectangle(0, 0, img.getWidth(null), img.getHeight(null));
		texture = new TexturePaint(img, rect);
	}
	@Override
	public String getName(){
		return text.attributeValue("name");
	}
}
