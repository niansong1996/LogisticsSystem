package edu.nju.lms.presentation.mouseListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.lms.VO.EnumTransformer;
import edu.nju.lms.data.ListType;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyLabel;
import edu.nju.lms.presentation.components.MyTextArea;
import edu.nju.lms.presentation.components.table.MyTableLabel;
import edu.nju.lms.presentation.config.ConfigReader;
import edu.nju.lms.presentation.config.PanelConfig;
import edu.nju.lms.presentation.frame.MainPanel;

/**
 * @author tj
 * @date 2015年12月11日
 */
public class LabelListener implements MouseListener {
	private MyTableLabel label;
	private UIController controller;
	private MainPanel panel;
	private MyTextArea area;
	private boolean showing;
	public LabelListener(MyTableLabel label, UIController controller) {
		this.label = label;
		this.controller = controller;
	}

	public void mouseClicked(MouseEvent e) {
		MyLabel typeLabel = null;
		String str = null;
		MyLabel idLabel = null;
		if (e.getClickCount() == 2) {
			if (!showing) {
				showing = true;
				this.panel = controller.getFrame().getPanel();
				// get the list type id
				typeLabel = (MyLabel) label.getComponents(0);
				str = typeLabel.getText();
				idLabel = (MyLabel) label.getComponents(1);
				String id = idLabel.getText();
				// transform the Chinese to panel name
				ListType t = EnumTransformer.str2ListType(str);
				String type = t.toString();
				area = new MyTextArea(id, type, controller);
				area.setBounds(650, 110, 420, 520);
				area.setVisible(true);
				panel.add(area);
				panel.repaint();
			}else{
				showing = false;
				area.setVisible(false);
			}
		}
	}

	

	public MyTextArea getArea() {
		return area;
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
