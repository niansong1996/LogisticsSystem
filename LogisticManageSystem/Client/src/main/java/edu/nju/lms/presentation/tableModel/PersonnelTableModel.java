package edu.nju.lms.presentation.tableModel;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import org.dom4j.Element;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.presentation.UIController;

/**
 * personnel table model
 * @author cuihao
 *
 */
public class PersonnelTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = -215942872351619032L;
	String[] head = { "选择", "ID", "姓名", "机构","职责", "薪水", "计次", "提成", "", ""};
	Vector<Object[]> data ;
	Class<?>[] typeArray = { Boolean.class, Object.class, Object.class,Object.class, Object.class, Double.class, Double.class,
			Double.class, Object.class, Object.class };
	ArrayList<PersonnelVO> changed = new ArrayList<PersonnelVO>();
	public PersonnelTableModel(Element element, UIController controller) {
		super();
		data = new Vector<Object[]>();
		ArrayList<PersonnelVO> persons = new ArrayList<PersonnelVO>();
		PersonnelVO personnel1 = new PersonnelVO("12345", "上山打老虎", "老虎打不到", "去打小松鼠", 0, 0, 0);
		PersonnelVO personnel2 = new PersonnelVO("12346", "上山打老虎", "老虎打不到", "去打小松鼠", 0, 0, 0);
		PersonnelVO personnel3 = new PersonnelVO("12347", "上山打老虎", "老虎打不到", "去打小松鼠", 0, 0, 0);
		persons.add(personnel1);
		persons.add(personnel2);
		persons.add(personnel3);
		for (PersonnelVO mperson: persons) {
			Object[] rowData = { new Boolean(false), mperson.getId(), mperson.getName(), mperson.getDepartmentNum(),mperson.getDuty(),
					new Double(mperson.getSalary()), new Double(mperson.getPerTime()), new Double(mperson.getBonus()),
					"", "" };
			data.add(rowData);
		}
	}

	public int getColumnCount() {
		return head.length;
	}

	public int getRowCount() {
		return data.size();
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
        PersonnelVO p = new PersonnelVO((String)data.get(rowIndex)[1], (String)data.get(rowIndex)[2], (String)data.get(rowIndex)[3],(String)data.get(rowIndex)[4],(Double)data.get(rowIndex)[5], (Double)data.get(rowIndex)[6], (Double)data.get(rowIndex)[7]);
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

	public ArrayList<PersonnelVO> getChanged() {
		return changed;
	}
	
}
