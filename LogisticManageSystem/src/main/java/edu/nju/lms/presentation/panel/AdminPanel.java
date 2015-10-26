package edu.nju.lms.presentation.panel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.lms.VO.UserVO;
import edu.nju.lms.businessLogicService.UserblService;

public class AdminPanel extends JPanel{
	private UserblService userbl;
	private AddPanel addPanel;
	private JButton btnAdd;
	private JButton btnFind;
	private JLabel jlName;
	private JTextField jtfName;
	
	public AdminPanel(UserblService userbl){
		this.userbl=userbl;
		addPanel=new AddPanel(userbl);
		this.setLayout(null);
		
		this.addBtnAdd();
		this.addBtnFind();
		this.addComponents();
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
				// TODO
				//addPanel.setVisible(true);
				add(addPanel);
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
				// TODO Auto-generated method stub
				String name=jtfName.getText();
				UserVO user=userbl.findUserInfo(name);
				//TODO
			}
			
		});
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(new ImageIcon("pictures/admin.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
