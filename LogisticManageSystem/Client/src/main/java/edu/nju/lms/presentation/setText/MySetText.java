package edu.nju.lms.presentation.setText;

import java.lang.reflect.Constructor;

import org.dom4j.Element;

import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.frame.MainPanel;

/**
 * 
 * @author cuihao
 *
 */
public class MySetText {
	String textClass = "";
	UIController controller;
	public MySetText(Element element, UIController controller) {
		textClass = element.attributeValue("textType");
		this.controller = controller;
	}
	public String getText(){
		if(textClass==null||textClass.isEmpty()||textClass.equals("null")) {
			return "";
		}
		Text text = null;
		try {
			Class<?> textC = Class.forName(MainPanel.packageName + "setText." + textClass);
			Constructor<?> ctr = textC.getConstructor();
			text = (Text) ctr.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return text.get(controller);
	}
}
