package edu.nju.lms.presentation.components.table;

import java.util.ArrayList;

import org.dom4j.Element;

import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyLabel;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class LogTable extends MyTable {
	private static final long serialVersionUID = -6644727278256120348L;
	private ArrayList<OperationVO> logs;
	private LogController control;
	public LogTable(Element element, UIController controller) {
		super(element, controller);
		logs = new ArrayList<OperationVO>();
		control = controller.getLogController();
	}

	@Override
	protected void getData() {
	}
	public MyTableLabel createLabel(OperationVO vo){
		MyLabel explain = new MyLabel(vo.getExplain());
		MyLabel time = new MyLabel(vo.getTime());
		MyLabel user = new MyLabel(vo.getUser());
		explain.setSize(280,30);
		time.setSize(280,30);
		user.setSize(290,80);
		java.awt.Component[] component = {explain,time,user};
		MyTableLabel label = new MyTableLabel(element, controller, 50, component, this);
		return label;
	}
}
