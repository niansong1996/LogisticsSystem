package edu.nju.lms.server.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

public class ServerActivator {
	private String userID;
	private String userPassword;
	private String dataBaseID;
	private String dataBasePassword;
	private String IPAddress;
	private String port;
	private boolean firstLogin = false;

	public ServerActivator(){
		
	}

	public static void main( String[] args ){
		ServerActivator activator = new ServerActivator();
		activator.InitServerUI();
	}
	public void activateServer(){
		String url = "jdbc:mysql:"+this.IPAddress+":"+port+"/lms?useUnicode=true&characterEncoding=utf8";
		JDBC.createJDBC(url,this.dataBaseID,this.dataBasePassword);

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
		frame.setLocationRelativeTo(null);
		final JPanel panel = new JPanel();
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

		this.readSettings();
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = text1.getText();
				@SuppressWarnings("deprecation")
				String password = text2.getText();
				if(user.equals(userID)&&password.equals(userPassword)){
					activateServer();
					panel.setVisible(false);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					initEnterUI(frame);
				}else{
					frame.setVisible(false);
					jumpHint("用户名或密码错误！");
					InitServerUI();
				}
			}
		}
				);	
	}
	public void initEnterUI(JFrame parent){
		JPanel panel = new JPanel();
		parent.getContentPane().add(panel);

		JLabel hint = new JLabel("服务器正在运行...");
		JButton settings = new JButton("设置");
		JButton halt = new JButton("停止服务器运行");

		panel.add(hint);
		panel.add(settings);
		panel.add(halt);
		settings.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				initSettingsUI();
			}
		});
		halt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	public void initSettingsUI(){
		final JFrame frame = new JFrame("设置");
		frame.setSize(200, 360);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);

		JLabel serverID = new JLabel("服务器登陆账号:");
		JLabel serverpwd = new JLabel("服务器登陆密码:");
		JLabel dbID = new JLabel("数据库登陆账号:");
		JLabel dbpwd = new JLabel("数据库密码:");
		JLabel dbIP = new JLabel("数据库IP");
		JLabel dbp = new JLabel("数据库端口:");

		final JTextField serverIDtf = new JTextField(15);
		final JTextField serverpwdtf = new JTextField(15);
		final JTextField dbIDtf = new JTextField(15);
		final JTextField dbpwdtf = new JTextField(15);
		final JTextField dbIPtf = new JTextField(15);
		final JTextField dbptf = new JTextField(15);

		JButton save = new JButton("保存");

		panel.add(serverID);panel.add(serverIDtf);
		panel.add(serverpwd);panel.add(serverpwdtf);
		panel.add(dbID);panel.add(dbIDtf);
		panel.add(dbpwd);panel.add(dbpwdtf);
		panel.add(dbIP);panel.add(dbIPtf);
		panel.add(dbp);panel.add(dbptf);

		panel.add(save);

		frame.setVisible(true);

		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				saveSettings(serverIDtf.getText(),serverpwdtf.getText(),dbIDtf.getText(),dbpwdtf.getText()
						,dbIPtf.getText(),dbptf.getText());
				readSettings();
				frame.setVisible(false);
			}

		});
	}
	public void saveSettings(String serverID,String serverPassword,String databaseID,String databasePassword,String databaseIP,String databasePort){
		File settings = new File("src/main/resources/server_settings.lms");
		try {
			FileWriter fw = new FileWriter(settings);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(serverID+"\n");
			bw.write(serverPassword+"\n");
			bw.write(databaseID+"\n");
			bw.write(databasePassword+"\n");
			bw.write(databaseIP+"\n");
			bw.write(databasePort+"\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void readSettings(){
		File settings = new File("src/main/resources/server_settings.lms");
		try {
			if(!settings.exists()){
				this.firstLogin = true;
				settings.createNewFile();
				this.jumpHint("这是您第一次登陆，请完成相关设置");
			}
			FileReader fr = new FileReader(settings);
			BufferedReader br = new BufferedReader(fr);
			this.userID = br.readLine();
			this.userPassword = br.readLine();
			this.dataBaseID = br.readLine();
			this.dataBasePassword = br.readLine();
			this.IPAddress = br.readLine();
			this.port = br.readLine();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void jumpHint(String msg){
		final JFrame frame = new JFrame("提示");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(250, 100);
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
				if(firstLogin) 	initSettingsUI();
			}
		}
				);	

	}
}
