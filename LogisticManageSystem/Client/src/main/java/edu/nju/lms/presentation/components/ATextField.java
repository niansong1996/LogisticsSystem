package edu.nju.lms.presentation.components;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.data.PersonType;

/**
 * @author tj
 * @date 2015年11月20日
 */
public class ATextField extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	MyTextField myText;
	MainTable table;

	public ATextField(MainTable table) {
		super();
		myText = new MyTextField();
		this.table = table;
		TableColumnModel columnModel = table.getColumnModel();
		for (int i = 1; i < 4; i++) {
			columnModel.getColumn(i).setCellRenderer(this);
			columnModel.getColumn(i).setCellEditor(this);
		}
	}

	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return myText ;
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return myText;
	}

}
