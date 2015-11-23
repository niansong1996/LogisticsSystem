package edu.nju.lms.presentation.tableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.dom4j.Element;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MainButton;
import edu.nju.lms.presentation.components.MainTable;
import edu.nju.lms.presentation.components.MyTextField;

/**
 * personnel table model
 * @author cuihao
 *
 */
public class PersonnelTableModel implements TableModel{
	ArrayList<PersonnelVO> personnel = new ArrayList<PersonnelVO>();
	MainTable table = null;
	private String[] name = {"编号","姓名","机构","职务","基本","计次","提成",""};
	public PersonnelTableModel(Element element, UIController controller, MainTable table) {
		super();
		PersonnelVO p1 = new PersonnelVO("123", "cuiods", "01", "总经理", 20000, 0, 100000);
		PersonnelVO p2 = new PersonnelVO("124", "tj", "01", "总经理", 20000, 0, 100000);
		personnel.add(p1);
		personnel.add(p2);
		this.table = table;
	}

	public void addTableModelListener(TableModelListener l) {
	}

	public Class<?> getColumnClass(int columnIndex) {
		if(columnIndex==7) {
			return MainButton.class;
		}
		return MyTextField.class;
	}

	public int getColumnCount() {
		return 8;
	}

	public String getColumnName(int columnIndex) {
		return name[columnIndex];
	}

	public int getRowCount() {
		return personnel.size();
	}

	public Object getValueAt(final int rowIndex, int columnIndex) {
		if(columnIndex==7){
			MainButton button = new MainButton("delete");
			button.addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent e) {
					personnel.remove(table.getTable().getSelectedRow());
					table.repaint();
				}
				public void mousePressed(MouseEvent e) {
				}
				public void mouseExited(MouseEvent e) {
				}
				public void mouseEntered(MouseEvent e) {	
				}
				public void mouseClicked(MouseEvent e) {
				}
			});
			return button;
		}
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
		if(columnIndex==7){
			table.remove((MainButton)aValue);
			table.repaint();
			return;
		}
		MyTextField text = (MyTextField) aValue;
		String change = text.getText();
		PersonnelVO personnelVO = personnel.get(rowIndex);
		switch(columnIndex){
		case 0: personnelVO.setId(change); break;
		case 1: personnelVO.setName(change); break;
		case 2: personnelVO.setDepartmentNum(change); break;
		case 3: personnelVO.setDuty(change);break;
		case 4: personnelVO.setSalary(Double.parseDouble(change)); break;
		case 5: personnelVO.setPerTime(Double.parseDouble(change)); break;
		case 6: personnelVO.setBonus(Double.parseDouble(change)); break;
		}
	}

}