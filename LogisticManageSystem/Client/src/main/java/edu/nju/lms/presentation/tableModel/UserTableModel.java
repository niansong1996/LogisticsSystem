package edu.nju.lms.presentation.tableModel;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.dom4j.Element;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.presentation.UIController;

/**
 * user table model
 * @see TableModel
 * 2015-11-20 00:39:42
 * @author cuihao
 *
 */
public class UserTableModel implements TableModel{
	
	private ArrayList<UserVO> users = new ArrayList<UserVO>();
	
	public UserTableModel(Element element, UIController controller) {
		//TODO
		//users = controller.getUserController().findAllUser();
		UserVO user = new UserVO("cui", "000000", PersonType.MANAGER);
		users.add(user);
	}

	public void addTableModelListener(TableModelListener l) {
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int columnIndex) {
		switch(columnIndex){
		case 0:return "序号";
		case 1:return "用户名";
		case 2:return "密码";
		case 3:return "权限";
		}
		return null;
	}

	public int getRowCount() {
		return users.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		UserVO user = users.get(rowIndex);
		switch(columnIndex){
		case 0: return rowIndex;
		case 1: return user.getUserName();
		case 2: return user.getPassword();
		case 3: return user.getPower().toString();
		}
		return null;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	public void removeTableModelListener(TableModelListener l) {
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}

}
