package edu.nju.lms.presentation.panel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.UserblService;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.main.App;
import edu.nju.lms.presentation.MainFrame;


/**
 *@author tj
 *@date 2015年10月26日
 */
public class TablePanel extends JPanel implements ActionListener{
	private DefaultTableModel userListModel;
	private JTable table;
	private UserblService userbl;
	private JScrollPane scrollPane;
	private Vector<UserVO> vData;
	private JButton updateButton;
	private JButton deleteButton;
	private JPanel buttonPanel;
	
	public TablePanel(UserblService userbl){
		this.userbl = userbl;
		initialize();
		showUsers();
	}
	public void initialize(){
		this.setSize(800,400);
		this.setLayout(new BorderLayout());
	//	this.setOpaque(false);
		scrollPane = new JScrollPane();
		buttonPanel = new JPanel();
		updateButton = new JButton("编辑");
		deleteButton = new JButton("删除");
	
		//表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("用户名");
		vColumns.add("密码");
		vColumns.add("权限");
	
		//数据
		vData = new Vector<UserVO>();
		//模型
		userListModel = new DefaultTableModel(vData, vColumns);
//		userListModel.addTableModelListener(new TableModelListener(){
//
//			public void tableChanged(TableModelEvent e) {
//				int row = e.getFirstRow();
//				int column = e.getColumn();
				
//				TableModel model = (TableModel)e.getSource();
//		        String columnName = model.getColumnName(column);
//		        Object data = model.getValueAt(row, column);
//		        UserVO userVO=null;
//		        if(columnName.equals("用户名")){
//		        	String pass = userListModel.getValueAt(row, column+1).toString();
//					String power = userListModel.getValueAt(row, column+2).toString();
//					userVO = new UserVO((String)data,pass,str2vo(power));
//		        }
//				String name = userListModel.getValueAt(row, column).toString();
//				
//				//UserVO userVO = new UserVO(name,pass,str2vo(power));
//				ResultMessage result = userbl.updateUser(userVO);
//				if(result.isSuccess()){
//					JOptionPane.showMessageDialog(null, "修改成功！");  
//				}else{
//					JOptionPane.showMessageDialog(null, result.getErrorMessage());  
//				}
				
//			}
//			
//		});
		//表格
		table = new JTable(userListModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.getViewport().add(table);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);
		buttonPanel.add(updateButton);
		buttonPanel.add(deleteButton);
		this.add("South",buttonPanel);
		this.setVisible(true);
		//add listeners
		updateButton.setActionCommand("update");
		deleteButton.setActionCommand("delete");
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
	}
	
	public void showUsers(){
		ArrayList<UserVO> users = userbl.findAllUser();
		if(users.isEmpty()){
			return;
		}
		for(UserVO user:users){
			Vector<String> userInfo = new Vector<String>();
			userInfo.add(user.getUserName());
			userInfo.add(user.getPassword());
			userInfo.add(user.getPower().toString());
			userListModel.addRow(userInfo);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("update")){
			MainFrame.addPanel.setVisible(true);
			MainFrame.mainFrame.setContentPane(MainFrame.addPanel);
		    MainFrame.mainFrame.repaint();
		}else if(e.getActionCommand().equals("delete")){
			String id =(String) table.getValueAt(table.getSelectedRow(),0);
			ResultMessage result = userbl.deleteUser(id);
			userListModel.removeRow(table.getSelectedRow());
			if(result.isSuccess()){
				JOptionPane.showMessageDialog(null, "删除成功！");  
			}else{
				JOptionPane.showMessageDialog(null,result.getErrorMessage());  
			}
		}
		repaint();
		
	}
	public PersonType str2vo(String s){
		PersonType type = null;
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
		 return type;
	}
	public DefaultTableModel getUserListModel() {
		return userListModel;
	}
	public void setUserListModel(DefaultTableModel userListModel) {
		this.userListModel = userListModel;
	}
	
}
