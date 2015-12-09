package edu.nju.lms.server.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ExportException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.dataService.DepartmentDataService;
import edu.nju.lms.dataService.FinanceAccountDataService;
import edu.nju.lms.dataService.FinancePaymentDataService;
import edu.nju.lms.dataService.FinanceReceiptDataService;
import edu.nju.lms.dataService.FinanceStrategyDataService;
import edu.nju.lms.dataService.ListDataService;
import edu.nju.lms.dataService.LogDataService;
import edu.nju.lms.dataService.PersonnelDataService;
import edu.nju.lms.dataService.TransportCommodityDataService;
import edu.nju.lms.dataService.TransportListDataService;
import edu.nju.lms.dataService.TransportToolDataService;
import edu.nju.lms.dataService.UserDataService;
import edu.nju.lms.dataService.WarehouseCheckinDataService;
import edu.nju.lms.dataService.WarehouseCheckoutDataService;
import edu.nju.lms.dataService.WarehouseDataService;
import edu.nju.lms.dataService.impl.DepartmentDataImpl;
import edu.nju.lms.dataService.impl.FinanceAccountDataImpl;
import edu.nju.lms.dataService.impl.FinancePaymentDataImpl;
import edu.nju.lms.dataService.impl.FinanceReceiptDataImpl;
import edu.nju.lms.dataService.impl.FinanceStrategyDataImpl;
import edu.nju.lms.dataService.impl.ListDataImpl;
import edu.nju.lms.dataService.impl.LogDataImpl;
import edu.nju.lms.dataService.impl.PersonnelDataImpl;
import edu.nju.lms.dataService.impl.TransportCommodityDataImpl;
import edu.nju.lms.dataService.impl.TransportListDataImpl;
import edu.nju.lms.dataService.impl.TransportToolDataImpl;
import edu.nju.lms.dataService.impl.UserDataImpl;
import edu.nju.lms.dataService.impl.WarehouseCheckinDataImpl;
import edu.nju.lms.dataService.impl.WarehouseCheckoutDataImpl;
import edu.nju.lms.dataService.impl.WarehouseDataImpl;

public class ServerActivator 
{
	public static void main( String[] args ){
		ServerActivator activator = new ServerActivator();
//		try {
//			UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		activator.InitServerUI();
	}
	public void activateServer(String port,String user,String password){
		String url = "jdbc:mysql://127.0.0.1:"+port+"/lms?useUnicode=true&characterEncoding=utf8";
		JDBC.createJDBC(url,user,password);

		try{    
			LocateRegistry.createRegistry(1099);  

			UserDataService userDataService = new UserDataImpl();  
			FinanceAccountDataService financeAccountDataService = new FinanceAccountDataImpl();
			DepartmentDataService departmentDataService = new DepartmentDataImpl();
			FinancePaymentDataService financePaymentDataService = new FinancePaymentDataImpl();
			FinanceReceiptDataService financeReceiptDataService = new FinanceReceiptDataImpl();
			FinanceStrategyDataService financeStrategyDataService = new FinanceStrategyDataImpl();
			PersonnelDataService personnelDataService = new PersonnelDataImpl();  
			TransportCommodityDataService transportCommodityDataService = new TransportCommodityDataImpl();
			TransportToolDataService transportToolDataService = new TransportToolDataImpl();
			WarehouseCheckinDataService warehouseCheckinDataService = new WarehouseCheckinDataImpl();
			WarehouseCheckoutDataService warehouseCheckoutDataService = new WarehouseCheckoutDataImpl();
			ListDataService listDataService = new ListDataImpl();
			LogDataService logDataService = new LogDataImpl();
			TransportListDataService transportListDataService = new TransportListDataImpl();
			WarehouseDataService warehouseDataService = new WarehouseDataImpl();


			Naming.rebind("UserDataService", userDataService);
			Naming.rebind("FinanceAccountDataService", financeAccountDataService);
			Naming.rebind("DepartmentDataService", departmentDataService);
			Naming.rebind("FinancePaymentDataService", financePaymentDataService);
			Naming.rebind("FinanceReceiptDataService", financeReceiptDataService);
			Naming.rebind("FinanceStrategyDataService", financeStrategyDataService);
			Naming.rebind("PersonnelDataService", personnelDataService);
			Naming.rebind("TransportCommodityDataService", transportCommodityDataService);
			Naming.rebind("TransportToolDataSevice", transportToolDataService);
			Naming.rebind("TransportToolDataService",transportToolDataService);
			Naming.rebind("WarehouseCheckinDataService", warehouseCheckinDataService);
			Naming.rebind("WarehouseCheckoutDataService", warehouseCheckoutDataService);
			Naming.rebind("ListDataService", listDataService);
			Naming.rebind("LogDataService", logDataService);
			Naming.rebind("TransportListDataService",transportListDataService);
			Naming.rebind("WarehouseDataService",warehouseDataService);

			//如果要把实例注册到另一台启动了RMI注册服务的机器上    
			//Naming.rebind("//192.168.1.105:1099/Hello",hello);    

			System.out.println("Server is ready.");    
		}catch(ExportException e1){
			this.jumpHint("服务器已经启动！");
		}catch (Exception e){    
			System.err.println("Server failed: \n" + e);    
		}    
	}

	public void InitServerUI(){
		final JFrame frame = new JFrame("服务器启动器");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(300, 120);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);

		JLabel label1 = new JLabel("用户名");
		JLabel label2 = new JLabel("密码");
		final JTextField text1 = new JTextField(20);
		final JPasswordField text2 = new JPasswordField(20);

		JButton btn = new JButton("启动服务器");

		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(btn);

		frame.setVisible(true);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = text1.getText();
				String password = text2.getText();
				if(user.equals("root")&&password.equals("9990"))
					activateServer("3306",user,password);
				else{
					jumpHint("用户名或密码错误！");
				}
				frame.setVisible(false);
			}
		}
				);	
	}
	
	public void jumpHint(String msg){
		final JFrame frame = new JFrame("提示");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(150, 100);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);

		JLabel label = new JLabel(msg);
		JButton btn = new JButton("确定");

		panel.add(label);
		panel.add(btn);

		frame.setVisible(true);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		}
				);	
		
	}
}
