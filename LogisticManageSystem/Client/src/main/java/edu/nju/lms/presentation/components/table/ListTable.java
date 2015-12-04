package edu.nju.lms.presentation.components.table;

import java.util.ArrayList;

import javax.swing.JLabel;

import org.dom4j.Element;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ListType;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.MyLabel;
import edu.nju.lms.presentation.components.MyTextField;

/**
 *@author tj
 *@date 2015年12月3日
 */
public class ListTable extends MyTable {
	private static final long serialVersionUID = 3558909374998616690L;
	private ArrayList<ListVO> lists;
	private ListController listControl;
	public ListTable(Element element, UIController controller) {
		super(element, controller);
		this.listControl = controller.getListController();
		lists = new ArrayList<ListVO>();
	}

	@Override
	protected void getData() {
		this.listControl = controller.getListController();
		lists = listControl.getAllList();
		for (int i = 0; i < lists.size(); i++) {
			MyTableLabel label = createLabel(lists.get(i));
			addData(label);
		}
	}
	public MyTableLabel createLabel(ListVO list) {
		ListType t = list.getType();
		ListState s = list.getState();
		String[] my_types = {"寄件单","收件单","装车单","装运单","收款单","到达单","派件单","入库单",
				"出库单","租金付款单","工资付款单","运费付款单"};
		String[] my_state = {"通过","不通过","等待"};
        int s_loc = s.ordinal();
		int t_loc = t.ordinal();
		String state = my_state[s_loc];
		String type = my_types[t_loc];
		MyLabel listType = new MyLabel(type);
		listType.setSize(80, 30);
		MyLabel listID = new MyLabel(list.getId());
		listID.setSize(100, 30);
		MyLabel listState = new MyLabel(state);
		listState.setSize(100, 30);
		
		java.awt.Component[] component = { listType, listID, listState};
		MyTableLabel label = new MyTableLabel(element, controller, 50, component, this);
		return label;
	}
}
