package edu.nju.lms.presentation.tableModel;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import edu.nju.lms.presentation.components.MainTable;
import edu.nju.lms.presentation.components.MyCombox;

public class ComBoxRender<String> extends DefaultCellEditor implements TableCellRenderer{

	public ComBoxRender(MainTable table,int col) {
		super(new JComboBox<String>());
		table.getColumnModel().getColumn(col).setCellRenderer(this);
		table.getColumnModel().getColumn(col).setCellEditor(this);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JComboBox<String> com = new JComboBox<String>();
		com.addItem((String) "管理员");
		return com;
	}

	
}
