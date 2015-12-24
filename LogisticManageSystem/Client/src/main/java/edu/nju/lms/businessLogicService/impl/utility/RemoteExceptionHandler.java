package edu.nju.lms.businessLogicService.impl.utility;

import edu.nju.lms.data.ResultMessage;

public class RemoteExceptionHandler {
	public static boolean reconnectRunning = false;
	public static ResultMessage handleRemoteException(Exception e){
		e.printStackTrace();
		if(!reconnectRunning){
			System.out.println("网络中断！");
			Reconnector rc = new Reconnector();
			Thread thread = new Thread(rc);
			thread.start();
		}
		return new ResultMessage(false,"网络未连接");
	}

}
