package edu.nju.lms.presentation.components.table;

import java.util.ArrayList;

import org.dom4j.Element;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.impl.user.UserController;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.components.EnumTransformer;
import edu.nju.lms.presentation.components.MyComboBox;
import edu.nju.lms.presentation.components.MyTextField;

public class UserTable extends MyTable{

	private static final long serialVersionUID = 1L;
	private ArrayList<UserVO> users;
	private UserController userController;

	public UserTable(Element element, UIController controller) {
		super(element, controller);
		users=new ArrayList<UserVO>();
		userController=controller.getUserController();
	}

	@Override
	protected void getData() {
		userController = controller.getUserController();
		users = userController.findAllUser();
		for (int i = 0; i < users.size(); i++) {
			MyTableLabel label = createLabel(users.get(i));
			addData(label);
		}
	}
	
	public MyTableLabel createLabel(UserVO user) {
		MyTextField userName=new MyTextField(user.getUserName());
		userName.setSize(150, 30);
		MyTextField password=new MyTextField(user.getPassword());
		password.setSize(150, 30);
		String type = EnumTransformer.PersonType2Str(user.getPower());
		MyComboBox userPower = new MyComboBox(element, controller);
		userPower.setSize(150, 30);
		userPower.setSelectedItem(type);
		java.awt.Component components[] = {userName, password, userPower};
		MyTableLabel label = new MyTableLabel(element, controller, 50, components, this);

		return label;

	}
	

}
