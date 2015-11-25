package edu.nju.lms.presentation.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MyComBoxRender<T> implements ListCellRenderer<T>{
	
	private DefaultListCellRenderer render = new DefaultListCellRenderer();
	
	public MyComBoxRender() {
		super();
	}

	public Component getListCellRendererComponent(JList<? extends T> list, T value, int index, boolean isSelected,
			boolean cellHasFocus) {
		JLabel renderer = (JLabel) render.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if (isSelected) {
			renderer.setBackground(Color.GRAY);
			renderer.setForeground(Color.WHITE);
		} else {
			renderer.setBackground(Color.WHITE);
		}
		list.setSelectionBackground(Color.DARK_GRAY);
		list.setBorder(null);
		renderer.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		renderer.setHorizontalAlignment(JLabel.CENTER);
		return renderer;
	}

}
