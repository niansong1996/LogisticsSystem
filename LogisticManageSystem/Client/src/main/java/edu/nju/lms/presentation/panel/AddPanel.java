package edu.nju.lms.presentation.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.UserblService;
import edu.nju.lms.businessLogicService.impl.user.UserblImpl;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.presentation.MainFrame;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月26日
 */
public class AddPanel extends JPanel implements ActionListener{
	private JTextField userName;
	private JTextField password;
	private JComboBox power;
	private UserblService userbl;
	private PersonType type;
	private JButton confirm;
	private JButton cancel;
	private JLabel nameLabel;
	private JLabel passLabel;
	private AdminPanel admin;
	
	private int operation;
	public AddPanel(UserblService userbl,int operation){
		this.userbl = userbl;
		this.operation = operation;
		initialize();
		addComponents();
		power.addItemListener(new ComboListener());
		this.setVisible(true);
		this.setSize(450, 150);
		this.setLocation(500, 50);
	}

	public void initialize(){
		userName = new JTextField(10);
		password = new JTextField(10);
		power = new JComboBox();
		confirm = new JButton("确定");
		cancel = new JButton("取消");
		nameLabel = new JLabel("用户名");
		passLabel = new JLabel("密码");
		power.addItem("总经理");
		power.addItem("高级财务人员");
		power.addItem("低级财务人员");
		power.addItem("营业厅业务员");
		power.addItem("中转中心业务员");
		power.addItem("仓库管理人员");
		power.addItem("快递员");
		power.setSelectedItem("快递员");
	}
	
	public void addComponents() {
		this.add(nameLabel);
		this.add(userName);
		this.add(passLabel);
		this.add(password);
		this.add(power);
		this.add(confirm);
		this.add(cancel);
		
		/**
		 * add listeners
		 */
		confirm.addActionListener(new ConfirmListener());
		cancel.addActionListener(this);
		repaint();
	}
	class ComboListener implements ItemListener{

		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED){
				 String s = e.getItem().toString();	 
				 if(s.equals("总经理")) {
					 type = PersonType.MANAGER;
				 }else if(s.equals("高级财务人员")){
					 type = PersonType.FINANCIAL_ADVANCED;
				 }else if(s.equals("低级财务人员")){
					 type = PersonType.FINANCIAL_NORMAL;
				 }else if(s.equals("营业厅业务员")){
					 type = PersonType.COUNTER_BUSSINESS;
				 }else if(s.equals("中转中心业务员")){
					 type = PersonType.COUNTER_INTERMEDIATE;
				 }else if(s.equals("仓库管理人员")){
					 type = PersonType.WAREHOUSE;
				 }else if(s.equals("快递员")){
					 type = PersonType.COURIER;
				 }
				 
			}
		
		}
	}
	
	class ConfirmListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
				String name = userName.getText();
				String pass = password.getText();
				if(name.equals("")||pass.equals("")){
					JOptionPane.showMessageDialog(null, "信息不完整！");  
				}else{
					UserVO user = new UserVO(name,pass,type);
					if(operation==0){
						ResultMessage result = userbl.addUser(user);
						if(result.isSuccess()){
							JOptionPane.showMessageDialog(null, "添加成功！");  
							userName.setText("");
							password.setText("");
						}else{
							JOptionPane.showMessageDialog(null, result.getErrorMessage());  
						}
					}else if(operation==1){
						ResultMessage result = userbl.updateUser(user);
						if(result.isSuccess()){
							JOptionPane.showMessageDialog(null, "修改成功！");  
							userName.setText("");
							password.setText("");
						}else{
							JOptionPane.showMessageDialog(null, result.getErrorMessage());  
						}
					}
				}
		
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		admin=new AdminPanel(userbl);
		this.setVisible(false);	
		MainFrame.mainFrame.setContentPane(admin);
	}
	
}
