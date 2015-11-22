package edu.nju.lms.presentation.tableModel;

import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.dom4j.Element;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyTextField;

/**
 * personnel table model
 * @author cuihao
 *
 */
public class PersonnelTableModel implements TableModel{
	ArrayList<PersonnelVO> personnel = new ArrayList<PersonnelVO>();
	private String[] name = {"编号","姓名","机构","职务","基本","计次","提成"};
	public PersonnelTableModel(Element element, UIController controller) {
		PersonnelVO p1 = new PersonnelVO("123", "cuiods", "01", "总经理", 20000, 0, 100000);
		PersonnelVO p2 = new PersonnelVO("124", "tj", "01", "总经理", 20000, 0, 100000);
		personnel.add(p1);
		personnel.add(p2);
	}

	public void addTableModelListener(TableModelListener l) {
	}

	public Class<?> getColumnClass(int columnIndex) {
		return MyTextField.class;
	}

	public int getColumnCount() {
		return 7;
	}

	public String getColumnName(int columnIndex) {
		return name[columnIndex];
	}

	public int getRowCount() {
		return personnel.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		PersonnelVO p = personnel.get(rowIndex);
		Field[] fields = p.getClass().getDeclaredFields();
		Field current = fields[columnIndex];
		current.setAccessible(true);
		Object get = null;
		try {
			get = current.get(p);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if(columnIndex <= 3){
			return new MyTextField((String) get);
		}else{
			Double num = (Double) get;
			double d = num;
			String str = d +"";
			return new MyTextField(str);
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	public void removeTableModelListener(TableModelListener l) {
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		MyTextField text = (MyTextField) aValue;
		String change = text.getText();
		PersonnelVO personnelVO = personnel.get(rowIndex);
		switch(columnIndex){
		case 0: personnelVO.setId(change); break;
		case 1: personnelVO.setName(change); break;
		case 2: personnelVO.setDepartment(change); break;
		case 3: personnelVO.setDuty(change);break;
		case 4: personnelVO.setSalary(Double.parseDouble(change)); break;
		case 5: personnelVO.setPerTime(Double.parseDouble(change)); break;
		case 6: personnelVO.setBonus(Double.parseDouble(change)); break;
		}
	}

}
