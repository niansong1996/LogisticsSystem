package edu.nju.lms.presentation.components;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTextArea;

import org.dom4j.Element;

import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.setText.MySetText;

/**
 * Text area used to show <b>inquireInfo</b><br>
 * <b>CANNOT</b> show other info.
 * 
 * @author cuihao
 * @date 2015-12-08 16:28:36
 * @see OrderInforVO
 */
public class MyTextArea extends JTextArea {

	private static final long serialVersionUID = 3593040264658965436L;

	TransportController transport;

	public MyTextArea(Element element, UIController controller) {
		transport = controller.getTransportController();
		setBounds(Integer.parseInt(element.attributeValue("x")), Integer.parseInt(element.attributeValue("y")),
				Integer.parseInt(element.attributeValue("w")), Integer.parseInt(element.attributeValue("h")));
		setView();
		// setLmsInfo();
		MySetText set = new MySetText(element, controller);
		setText(set.getText());
	}

	// 审批单据专用构造函数
	public MyTextArea(String id, String type, UIController controller) {
		setView();
		MySetText set = new MySetText(null, controller);
		setText(set.getListText(id, type));
	}

	private void setView() {
		setOpaque(false);
		setEditable(false);
		setFont(new Font("微软雅黑", Font.PLAIN, 23));
		setAutoscrolls(false);
	}

	protected void paintComponent(Graphics g) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new FileInputStream("src/main/resources/pictures/loginback1.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		super.paintComponent(g);
	}
}
