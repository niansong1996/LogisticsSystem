package edu.nju.lms.presentation.tableModel;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import org.dom4j.Element;

import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.data.DepartmentType;
import edu.nju.lms.presentation.UIController;

/**
 * @author tj
 * @date 2015年11月25日
 */
public class DepartmentTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] head = { "选择", "地点", "机构类型", "机构编号" };
	Vector<Object[]> data;
	Class<?>[] typeArray = { Boolean.class, Object.class, Object.class, Object.class };
	ArrayList<DepartmentVO> changed = new ArrayList<DepartmentVO>();

	public DepartmentTableModel(Element element,UIController controller){
		data = new Vector<Object[]>();
		DepartmentVO de1 = new DepartmentVO(DepartmentType.BUSINESSHALL,"555","NanJing");
		Object[] rowData = { new Boolean(false), de1.getLocation(),de1.getType(),de1.getDepartmentNum()};
		data.add(rowData);
	}
	public int getRowCount() {
		return data.size();
	}

	public int getColumnCount() {
		return head.length;
	}

	public String getColumnName(int column) {
		return head[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex)[columnIndex];
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		data.get(rowIndex)[columnIndex] = aValue;
		DepartmentType type =null;
	//	(String) data.get(rowIndex)[2];
		DepartmentVO p = new DepartmentVO(type,(String) data.get(rowIndex)[1],(String) data.get(rowIndex)[3]);
		changed.add(p);
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public Class<?> getColumnClass(int columnIndex) {
		return typeArray[columnIndex];
	}

	public void removeRow(int row) {
		data.remove(row);
	}

	public void removeRows(int row, int count) {
		for (int i = 0; i < count; i++) {
			if (data.size() > row) {
				data.remove(row);
			}
		}
	}

	public Vector<Object[]> getData() {
		return data;
	}

	public void setData(Vector<Object[]> person) {
		this.data = person;
	}

	//public ArrayList<PersonnelVO> getChanged() {
	//	return changed;
//	}

}
