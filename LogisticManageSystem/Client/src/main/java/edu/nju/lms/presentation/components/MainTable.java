package edu.nju.lms.presentation.components;

import java.awt.Dimension;
import java.lang.reflect.Constructor;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.dom4j.Element;

import edu.nju.lms.presentation.MainPanel;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.tableModel.ComBoxRender;

/**
 * General table class
 * @author cuihao
 * 2015-11-20 00:44:01
 * test xml file: <unit name ="mainTable" class = "panel.MainTable" x="0" y="0" w="500" h="500" type="0" dataType = "UserVO" rw = "20" cw = "40" model = "panel.UserTableModel"/>
 */
public class MainTable extends JPanel{
	private JTable table;
	protected UIController controller;
	protected Element element;
	private JScrollPane scrollpane;
	private AbstractTableModel model;
	private ComBoxRender box;
	/**
	 * create model and initialize table
	 * @param element
	 * @param controller
	 */
	public MainTable(Element element, UIController controller) {
		this.element = element;
		this.controller = controller;
		setOpaque(false);
		setLayout(null);
		setBounds(Integer.parseInt(element.attributeValue("x")),Integer.parseInt(element.attributeValue("y")),
				Integer.parseInt(element.attributeValue("w")),Integer.parseInt(element.attributeValue("h")));
		initializeTable();
		setWidth(element.attributeValue("cw"), element.attributeValue("rw"));
		//new ATextField(this);
	}
	
	/**
	 * create {@link TableModel} according to model name
	 * create instance of {@link JTable} using TableModel and add it to the panel
	 * 
	 */
	private void initializeTable() {
		/**
		 * create new instance of my TableModel
		 */
		try {
			Class<?> myModel = Class.forName(MainPanel.packageName+"tableModel."+element.attributeValue("model"));
			Constructor<?> ctr = myModel.getConstructor(Element.class,UIController.class);
			model = (AbstractTableModel) ctr.newInstance(element, controller);
		} catch (Exception e) {
			e.printStackTrace();
		}
		table = new JTable(model);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(false);
		
		/**
		 * initialize components
		 */
		TableColumn tc1 = table.getColumnModel().getColumn(0);
		JCheckBox ckb = new JCheckBox();
		tc1.setCellEditor(new DefaultCellEditor(ckb));
        
		/**
		 * sort method
		 * when click the column, data will be sorted
		 */
//		RowSorter<javax.swing.table.TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
//        table.setRowSorter(sorter);
        setOpaque();
        scrollpane.setBounds(2,2,this.getWidth()-2,this.getHeight()-2);
		add(scrollpane);
		setCombox();
	}
	
	/**
	 * set opaque of the table
	 */
	private void setOpaque(){
		/**
		 * set JScrollpane
		 */
		scrollpane = new JScrollPane();
        scrollpane.getViewport().setOpaque(false);
        scrollpane.setOpaque(false);
        scrollpane.setViewportView(table); 
        scrollpane.setColumnHeaderView(table.getTableHeader()); 
        scrollpane.getColumnHeader().setOpaque(false);
        /**
         * set table
         */
//        table.setOpaque(false);  
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
//        render.setOpaque(false);
//        table.setDefaultRenderer(Object.class,render);
        /**
         * table header opaque
         */
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(30, 30));   
        header.setOpaque(false);
        header.getTable().setOpaque(false);
        header.setDefaultRenderer(render);  
        TableCellRenderer headerRenderer = header.getDefaultRenderer();   
        if (headerRenderer instanceof JLabel) {  
            ((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);   
            ((JLabel) headerRenderer).setOpaque(false);   
        } 
	}
	
	public void setCombox(){
		if(element.attributeValue("dataType").equals("ComBox")){
			try {
				Class<?> myBox = Class.forName(MainPanel.packageName+"tableModel.ComBoxRender");
				Constructor<?> ctr = myBox.getConstructor(MainTable.class,int.class);
				box = (ComBoxRender) ctr.newInstance(this, 2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * set width of row and column
	 * @param cwStr column width
	 * @param rwStr row width
	 */
	private void setWidth(String cwStr, String rwStr){
//		int cw = Integer.parseInt(cwStr);
//		int rw = Integer.parseInt(rwStr);
//		for (int i = 0; i < table.getColumnCount(); i++) {
//			table.getColumnModel().getColumn(i).setPreferredWidth(cw);
//		}
		table.setRowHeight(40);
	}

	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}

	public AbstractTableModel getModel() {
		return model;
	}

	public void setModel(AbstractTableModel model) {
		this.model = model;
	}
	public TableColumnModel getColumnModel(){
		return table.getColumnModel();
	}
	
}
