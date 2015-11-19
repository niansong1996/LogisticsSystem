package edu.nju.lms.presentation.panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.dom4j.Element;

import edu.nju.lms.presentation.UIController;

/**
 * General table class
 * @author cuihao
 * 2015-11-20 00:44:01
 * test xml file: <unit name ="mainTable" class = "panel.MainTable" x="0" y="0" w="500" h="500" type="0" dataType = "UserVO" rw = "20" cw = "40"/>
 */
public class MainTable extends JPanel{
	private JTable table;
	protected UIController controller;
	protected Element element;
	private JScrollPane scrollpane;
	private TableModel model;
	/**
	 * create model and initialize table
	 * @param element
	 * @param controller
	 */
	public MainTable(Element element, UIController controller) {
		this.element = element;
		this.controller = controller;
		setOpaque(false);
		setBounds(Integer.parseInt(element.attributeValue("x")),Integer.parseInt(element.attributeValue("y")),
				Integer.parseInt(element.attributeValue("w")),Integer.parseInt(element.attributeValue("h")));
		initializeTable();
		setWidth(element.attributeValue("cw"), element.attributeValue("rw"));
	}
	
	/**
	 * create {@link TableModel} according to type
	 * create instance of {@link JTable} using TableModel and add it to the panel
	 */
	private void initializeTable() {
		if(element.attributeValue("dataType").equals("UserVO")){
			model = new UserTableModel(element, controller);
		}
		table = new JTable(model);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		scrollpane = new JScrollPane(table);
		/**
		 * sort method
		 * when click the column, data will be sorted
		 */
		RowSorter<javax.swing.table.TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
		add(scrollpane);
	}
	
	/**
	 * set width of row and column
	 * @param cwStr column width
	 * @param rwStr row width
	 */
	private void setWidth(String cwStr, String rwStr){
		int cw = Integer.parseInt(cwStr);
		int rw = Integer.parseInt(rwStr);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(cw);
		}
		table.setRowHeight(rw);
	}

	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}

	public TableModel getModel() {
		return model;
	}

	public void setModel(TableModel model) {
		this.model = model;
	}
	
}
