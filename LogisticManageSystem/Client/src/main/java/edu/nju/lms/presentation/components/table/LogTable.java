package edu.nju.lms.presentation.components.table;

import org.dom4j.Element;

import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyLabel;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class LogTable extends MyTable {
	private static final long serialVersionUID = -6644727278256120348L;
	public LogTable(Element element, UIController controller) {
		super(element, controller);
	}

	@Override
	protected void getData() {
	}
	public MyTableLabel createLabel(OperationVO vo){
		MyLabel explain = new MyLabel(vo.getExplain());
		MyLabel time = new MyLabel(vo.getTime());
		MyLabel user = new MyLabel(vo.getUser());
		explain.setSize(250,30);
		time.setSize(200,30);
		user.setSize(150,30);
		java.awt.Component[] component = {explain,time,user};
		MyTableLabel label = new MyTableLabel(element, controller, 50, component, this);
		return label;
	}

	@Override
	protected ResultMessage deleteData(MyTableLabel label) {
		return null;
	}
}
