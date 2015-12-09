package edu.nju.lms.businessLogicService.impl.utility;

import edu.nju.lms.data.ResultMessage;

public class RemoteExceptionHandler {
	public static ResultMessage handleRemoteException(Exception e){
		return new ResultMessage(false,"网络未连接");
	}
}
