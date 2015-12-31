package edu.nju.lms.businessLogicService.impl.utility;

import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogic.NoBusinessLogicException;
import edu.nju.lms.presentation.components.MyDialog;

public class Reconnector implements Runnable{

	public void run() {
		RemoteExceptionHandler.reconnectRunning = true;
		for(int i=0;i<10;i++){
			new MyDialog("5s后尝试重新连接("+i+")！");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			if(DataServiceFactory.verifyConnection()){
				new MyDialog("重新连接成功！");
				try {
					BusinessLogicFactory.getLogController().reconnect();
					BusinessLogicFactory.getUserController().reconnect();
					BusinessLogicFactory.getDepartmentController().reconnect();
					BusinessLogicFactory.getFinanceController().reconnect();
					BusinessLogicFactory.getListController().reconnect();
					BusinessLogicFactory.getPersonnelController().reconnect();
					BusinessLogicFactory.getWarehouseController().reconnect();
					BusinessLogicFactory.getTransportController().reconnect();
				} catch (NoBusinessLogicException e1) {
					e1.printStackTrace();
				}
				break;
			}
		}
		RemoteExceptionHandler.reconnectRunning = false;
	}

}
