package edu.nju.lms.presentation.panel;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.dom4j.Element;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.presentation.UIController;

public class MainTable extends JPanel{
	private JTable table;
	private int colNum;
	private int rowNum;
	protected UIController controller;
	protected Element element;
	private JScrollPane scrollpane;
	String[] colnames;
	public MainTable(Element element, UIController controller) {
		this.element = element;
		Element att = element.element("attributes");
		colNum = Integer.parseInt(att.attributeValue("col"));
		rowNum = Integer.parseInt(att.attributeValue("row"));
		colnames = att.attributeValue("colnames").split(",");
		this.controller = controller;
		setBounds(Integer.parseInt(element.attributeValue("x")),Integer.parseInt(element.attributeValue("y")),
				Integer.parseInt(element.attributeValue("w")),Integer.parseInt(element.attributeValue("h")));
		initializeTable();
	}
	
	
	private void initializeTable() {
		Vector<String> colname = new Vector<String>();
		for(int i = 0; i < colnames.length; i++) {
			colname.add(colnames[i]);
		}
		if(element.element("attributes").attributeValue("dataType").equals("UserVO")){
			Vector<UserVO> dataType = new Vector<UserVO>();
			table = new JTable(new DefaultTableModel(colname,dataType));
		}
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		scrollpane.getViewport().add(table);
		table.setFillsViewportHeight(true);
		add(scrollpane);
	}

	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public int getColNum() {
		return colNum;
	}
	public void setColNum(int colNum) {
		this.colNum = colNum;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	
}
