package edu.nju.lms.presentation.tableModel;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.dom4j.Element;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MainTable;
import edu.nju.lms.presentation.components.MyCombox;
import edu.nju.lms.presentation.components.MyTextField;

/**
 * user table model
 * 
 * @see TableModel 2015-11-20 00:39:42
 * @author cuihao
 *
 */
public class UserTableModel implements TableModel {
	private Class[] cellType = { String.class, MyTextField.class, MyTextField.class, MyCombox.class };
	private ArrayList<UserVO> users = new ArrayList<UserVO>();

	public UserTableModel(Element element, UIController controller, MainTable table) {
		UserVO us1 = new UserVO("000", "555", PersonType.ADMINISTRATOR);
		UserVO us2 = new UserVO("000", "12345", PersonType.COUNTER_BUSSINESS);
		users.add(us1);
		users.add(us2);
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
			MyCombox<PersonType> com = new MyCombox<PersonType>();
			com.addItem(PersonType.ADMINISTRATOR);
			com.addItem(PersonType.COUNTER_BUSSINESS);
			com.addItem(PersonType.COUNTER_INTERMEDIATE);
			com.addItem(PersonType.COURIER);
			com.addItem(PersonType.FINANCIAL_ADVANCED);
			com.addItem(PersonType.FINANCIAL_NORMAL);
			com.addItem(PersonType.MANAGER);
			com.addItem(PersonType.WAREHOUSE);
			com.setSelectedItem(user.getPower());
			return com;
		}
		return null;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 0 ? false : true;
	}

	public void removeTableModelListener(TableModelListener l) {
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		String change = "";
		PersonType type  = null;
		if(columnIndex<=2){
			MyTextField text = (MyTextField) aValue;
			change = text.getText();
		}else{
			JComboBox<PersonType> com = (JComboBox<PersonType>) aValue;
			type = (PersonType) com.getSelectedItem();
		}
		UserVO user = users.get(rowIndex);
		switch (columnIndex) {
		case 1:
			user.setUserName(change);
			break;
		case 2:
			user.setPassword(change);
			break;
		case 3:
			user.setPower(type);
		}

	}

}
