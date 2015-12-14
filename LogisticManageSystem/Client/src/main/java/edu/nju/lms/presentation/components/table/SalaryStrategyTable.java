package edu.nju.lms.presentation.components.table;

import org.dom4j.Element;

import edu.nju.lms.VO.EnumTransformer;
import edu.nju.lms.VO.SalaryStrategyVO;
import edu.nju.lms.businessLogicService.impl.finance.FinanceController;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyLabel;
import edu.nju.lms.presentation.components.MyTextField;

/**
 *@author tj
 *@date 2015年12月14日
 */
public class SalaryStrategyTable extends MyTable {
	private static final long serialVersionUID = 8777934009145482382L;
	private String[] personTypes ={"总经理","高级财务人员","普通财务人员","管理员","中转中心业务员","营业厅业务员","仓库管理人员",
			"快递员","司机"};
	private String[] personItems ={"月薪","月薪","月薪","月薪","月薪","月薪","月薪",
			"按次提成","计次"};
	private FinanceController control;
	public SalaryStrategyTable(Element element, UIController controller) {
		super(element, controller);
		this.control = controller.getFinanceController();
	}

	@Override
	protected void getData() {
		String[] personTypes ={"总经理","高级财务人员","普通财务人员","管理员","中转中心业务员","营业厅业务员","仓库管理人员",
				"快递员","司机"};
		this.control = controller.getFinanceController();
		for(int i =0;i<personTypes.length;i++){
			MyTableLabel label = createLabel(i);
			addData(label);
		}
	}

	@Override
	protected ResultMessage deleteData(MyTableLabel label) {
		return null;
	}
	public MyTableLabel createLabel(int i){
		String[] personTypes ={"总经理","高级财务人员","普通财务人员","管理员","中转中心业务员","营业厅业务员","仓库管理人员",
				"快递员","司机"};
		String[] personItems ={"月薪","月薪","月薪","月薪","月薪","月薪","月薪",
				"按次提成","计次"};
		MyLabel label = new MyLabel(personTypes[i]);
		label.setSize(100,50);
		MyComboBox<String> box = new MyComboBox<String>();
		box.setSize(150, 30);
		String[] items = {"月薪","计次","按次提成"};
		for(int j =0;j<items.length;j++){
			box.addItem(items[j]);
		}
		box.setSelectedItem(personItems[i]);
		SalaryStrategyVO vo = control.findSalaryStrategy(EnumTransformer.str2PersonType(personTypes[i]));
		if(vo==null){
			MyTextField basicField = new MyTextField("");
			basicField.setSize(100,30);
			MyTextField bonusField = new MyTextField("");
			bonusField.setSize(100,30);
			MyTextField perTimeField = new MyTextField("");
			perTimeField.setSize(100,30);
			java.awt.Component[] component = {label,box,basicField,bonusField,perTimeField};
			MyTableLabel lab = new MyTableLabel(element, controller, 50, component, this);
			return lab;
		}
		MyTextField basicField = new MyTextField(vo.getBasic()+"");
		basicField.setSize(100,30);
		MyTextField bonusField = new MyTextField(vo.getBonus()+"");
		bonusField.setSize(100,30);
		MyTextField perTimeField = new MyTextField(vo.getPerTime()+"");
		perTimeField.setSize(100,30);
		java.awt.Component[] component = {label,box,basicField,bonusField,perTimeField};
		MyTableLabel lab = new MyTableLabel(element, controller, 50, component, this);
		return lab;
	}
}
