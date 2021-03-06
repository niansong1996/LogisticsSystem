package edu.nju.lms.presentation.mouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.DateChooser;
import edu.nju.lms.presentation.components.MyDialog;
import edu.nju.lms.presentation.components.table.LogTable;
import edu.nju.lms.presentation.components.table.MyTableLabel;

/**
 *@author tj
 *@date 2015年12月5日
 */
public class SearchLogButtonListener extends ButtonListener {
	private DateChooser start;
	private DateChooser end;
	private ArrayList<OperationVO> logs;
	private LogController control;
	private LogTable table;
	public SearchLogButtonListener(ArrayList<Component> units, UIController controller, Component button) {
		super(units, controller, button);
		this.logs = new ArrayList<OperationVO>();
		this.control = controller.getLogController();
		this.start = (DateChooser) units.get(0);
		this.end = (DateChooser) units.get(1);
		this.table = (LogTable) units.get(2);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Calendar s = start.getCalendar();
		Calendar d = end.getCalendar();
		logs = control.getLogInfo(s, d);
		if(logs.isEmpty()){
			new MyDialog("此段时间无操作记录",true,controller);
		}
		ArrayList<MyTableLabel> labels = new ArrayList<MyTableLabel>();
		for(int i =0;i<logs.size();i++){
			OperationVO vo = logs.get(i);
			labels.add(table.createLabel(vo));
		}
		table.setDataList(labels);
	}
}
