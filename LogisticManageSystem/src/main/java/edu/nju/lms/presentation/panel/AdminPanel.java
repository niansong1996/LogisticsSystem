package edu.nju.lms.presentation.panel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.UserblService;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.presentation.MainFrame;

public class AdminPanel extends JPanel{
	private UserblService userbl;
	private AddPanel addPanel;
	private JButton btnAdd;
	private JButton btnFind;
	private JLabel jlName;
	private JTextField jtfName;
	private TablePanel tablePanel;
	public AdminPanel(UserblService userbl){
		this.userbl=userbl;
		addPanel=new AddPanel(userbl,0);
		tablePanel = new TablePanel(userbl, addPanel);
		this.setLayout(null);
		tablePanel.setBounds(390, 100,650,500);
		this.addBtnAdd();
		this.addBtnFind();
		this.addComponents();
		this.add(tablePanel);
	}
	
	public void addComponents(){	
		jlName=new JLabel("User Name : ");
		jlName.setBounds(50, 200, 100, 50);
		jtfName=new JTextField(30);
		jtfName.setBounds(180, 210, 120, 30);
		
		this.add(jlName);
		this.add(jtfName);
	}
	
	public void addBtnAdd(){
		btnAdd=new JButton("Add");
		btnAdd.setBounds(60, 600, 90, 23);
		this.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				MainFrame.mainFrame.setContentPane(addPanel);
				repaint();
			}
		});
	}
	
	public void addBtnFind(){
		btnFind=new JButton("Search");
		btnFind.setBounds(200,600,90,23);
		this.add(btnFind);
		
		btnFind.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String name=jtfName.getText();
				//UserVO user=userbl.findUserInfo(name);
				UserVO user = new UserVO("0000000001", "123456", PersonType.ADMINISTRATOR);
				Vector<String> userInfo = new Vector<String>();
				userInfo.add(user.getUserName());
				userInfo.add(user.getPassword());
				userInfo.add(user.getPower().toString());
				DefaultTableModel userListModel = tablePanel.getUserListModel();
				userListModel.setRowCount(0);
				userListModel.addRow(userInfo);
			}
			
		});
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(new ImageIcon("pictures/admin.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
