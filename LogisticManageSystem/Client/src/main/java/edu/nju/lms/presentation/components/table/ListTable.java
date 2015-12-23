package edu.nju.lms.presentation.components.table;

import java.util.ArrayList;

import org.dom4j.Element;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.data.ListType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.EnumTransformer;
import edu.nju.lms.presentation.components.MyLabel;

/**
 * @author tj
 * @date 2015年12月3日
 */
public class ListTable extends MyTable {
	private static final long serialVersionUID = 3558909374998616690L;

	public ListTable(Element element, UIController controller) {
		super(element, controller);
	}

	@Override
	protected void getData() {
		ListController control = controller.getListController();
		ArrayList<ListVO> vos = control.getListInfo(ListType.SEND);
		if(vos!=null){
			for(ListVO vo : vos){
				addData(createLabel(vo));
			}
		}
	}

	public MyTableLabel createLabel(ListVO list) {
		String type ="";
		if (list.getType() != null) {
			type = EnumTransformer.listType2Str(list.getType());
		}
		String state = EnumTransformer.listState2Str(list.getState());
		MyLabel listType = new MyLabel(type);
		listType.setSize(80, 30);
		MyLabel listID = new MyLabel(list.getId());
		listID.setSize(100, 30);
		MyLabel listState = new MyLabel(state);
		listState.setSize(100, 30);

		java.awt.Component[] component = { listType, listID, listState };
		MyTableLabel label = new MyTableLabel(element, controller, 50, component, this);
		return label;
	}

	@Override
	protected ResultMessage deleteData(MyTableLabel label) {
		return null;
	}
}
