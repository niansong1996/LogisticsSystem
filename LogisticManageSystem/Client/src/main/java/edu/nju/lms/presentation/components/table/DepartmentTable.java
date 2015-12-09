package edu.nju.lms.presentation.components.table;

import java.util.ArrayList;

import javax.swing.JTextField;

import org.dom4j.Element;

import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.data.DepartmentType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyTextField;

/**
 * @author tj
 * @date 2015年12月2日
 */
public class DepartmentTable extends MyTable {

	private static final long serialVersionUID = 1397024982369005487L;
	private ArrayList<DepartmentVO> departments = new ArrayList<DepartmentVO>();

	public DepartmentTable(Element element, UIController controller) {
		super(element, controller);
	}

	@Override
	protected void getData() {
		departments = new ArrayList<DepartmentVO>();
		// DepartmentVO vo = new DepartmentVO(DepartmentType.BUSINESSHALL,
		// "222", "555");
		// for (int i = 0; i < 10; i++) {
		// departments.add(vo);
		// }
		DepartmentController dc = controller.getDepartmentController();
		departments = dc.showAllDepartments();
		if (departments.isEmpty()) {
			return;
		}
		for (int i = 0; i < departments.size(); i++) {
			MyTableLabel label = createLabel(departments.get(i));		
			addData(label);
		}
	}
	public MyTableLabel createLabel(DepartmentVO department){
		DepartmentType t = department.getType();
		String type = "";
		switch (t) {
		case BUSINESSHALL: 
			type = "营业厅";
			break;
		case TRANSITCENTER:
			type = "中转中心";
			break;
		}
		MyComboBox<?> box = new MyComboBox<Object>(element, controller);
		box.setSelectedItem(type);
		box.setSize(150,30);
		MyTextField location = new MyTextField(department.getLocation());
		location.setSize(200,30);
		MyTextField num = new MyTextField(department.getDepartmentNum());
		num.setSize(200,30);
		java.awt.Component[] component = {location, box, num};
		MyTableLabel label = new MyTableLabel(element, controller, 50, component, this);
		return label;
		
	}

	@Override
	protected ResultMessage deleteData(MyTableLabel label) {
		DepartmentController department = controller.getDepartmentController();
		JTextField field = (JTextField) label.getComponents(2);
		return department.deleteDepartment(field.getText());
	}

}
