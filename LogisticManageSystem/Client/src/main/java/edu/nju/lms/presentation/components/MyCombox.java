package edu.nju.lms.presentation.components;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicComboBoxUI;

import org.dom4j.Element;

import edu.nju.lms.presentation.UIController;

public class MyCombox<T> extends JComboBox<T>{
	public MyCombox(Element element, UIController controller) {
		setOpaque(false);
		setUI(new BasicComboBoxUI(){
			public void installUI(JComponent comboBox) {
                super.installUI(comboBox);
                listBox.setForeground(Color.WHITE);
                listBox.setSelectionBackground(new Color(0,0,0,0));
                listBox.setSelectionForeground(Color.BLACK);
            }
             
            protected JButton createArrowButton() {
                return super.createArrowButton();
            }
		});
	}
	
	public MyCombox(){
		this(null,null);
	}
}
