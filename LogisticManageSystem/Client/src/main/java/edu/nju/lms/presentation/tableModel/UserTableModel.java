package edu.nju.lms.presentation.tableModel;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import org.dom4j.Element;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.ATextField;
import edu.nju.lms.presentation.components.MyTextField;

/**
 * user table model
 * 
 * @see TableModel 2015-11-20 00:39:42
 * @author cuihao
 *
 */
public class UserTableModel implements TableModel {
	private Class[] cellType = { String.class, MyTextField.class, MyTextField.class, MyTextField.class };
	private ArrayList<UserVO> users = new ArrayList<UserVO>();

	public UserTableModel(Element element, UIController controller) {
		UserVO us = new UserVO("000", "555", PersonType.ADMINISTRATOR);
		users.add(us);
		users.add(us);
		// users = controller.getUserController().findAllUser();
	}

	public void addTableModelListener(TableModelListener l) {
	}

	public Class<?> getColumnClass(int columnIndex) {
		return cellType[columnIndex];
	}

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "序号";
		case 1:
			return "用户名";
		case 2:
			return "密码";
		case 3:
			return "权限";
		}
		return null;
	}

	public int getRowCount() {
		return users.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		UserVO user = users.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return rowIndex+1;
		case 1:
			return new MyTextField(user.getUserName());
		case 2:
			return new MyTextField(user.getPassword());
		case 3:
			return new MyTextField(user.getPower().toString());
		}
		return null;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 0 ? false : true;
	}

	public void removeTableModelListener(TableModelListener l) {
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		UserVO user = users.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return;
		case 1:
			user.setUserName((String) aValue);
			break;
		case 2:
			user.setPassword((String) aValue);
			break;
		// TODO
		}

	}

}
