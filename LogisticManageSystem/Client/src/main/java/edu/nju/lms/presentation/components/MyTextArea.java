package edu.nju.lms.presentation.components;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JTextArea;

import org.dom4j.Element;

import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.mouseListener.InquireListener;

/**
 * Text area used to show <b>inquireInfo</b><br>
 * <b>CANNOT</b> show other info.
 * @author cuihao
 * @date 2015-12-08 16:28:36
 * @see OrderInforVO
 */
public class MyTextArea extends JTextArea{

	private static final long serialVersionUID = 3593040264658965436L;
	
	TransportController transport;
	
	public MyTextArea(Element element, UIController controller) {
		transport = controller.getTransportController();
		setBounds(Integer.parseInt(element.attributeValue("x")), Integer.parseInt(element.attributeValue("y")),
				Integer.parseInt(element.attributeValue("w")), Integer.parseInt(element.attributeValue("h")));
		setOpaque(false);
		setEditable(false);
		setFont(new Font("微软雅黑",Font.PLAIN,23));
		setAutoscrolls(false);
		setLmsInfo();
	}
	
	/**
	 * set {@link OrderInforVO} text
	 */
	private void setLmsInfo(){
		String id = null;
		try {
			/**
			 * read commodity number
			 */
			BufferedReader br = new BufferedReader(new FileReader("temp.lms"));
			id = br.readLine();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(id!=null) {
			/**
			 * find info
			 */
			OrderInforVO info = transport.checkOrderInfor(id);
			if(info!=null) {
				append("快递编号："+info.getExpressNum()+"\n");
				append("快递状态："+info.getShipState().toString()+"\n");
				for(String s:info.getTrack()) {
					append(s+"\n");
				}
			} else {
				append("快递不存在！");
			}
		}else{
			append("文件读写错误！");
		}
	}

}
