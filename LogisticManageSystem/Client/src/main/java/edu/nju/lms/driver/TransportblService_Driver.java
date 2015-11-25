package edu.nju.lms.driver;

import java.util.ArrayList;

import edu.nju.lms.VO.ArrivalVO;
import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.VO.SendVO;
import edu.nju.lms.VO.VehicleVO;
import edu.nju.lms.businessLogicService.TransManageblService;
import edu.nju.lms.businessLogicService.TransProcessblService;
import edu.nju.lms.businessLogicService.impl.transport.TransManageblImpl;
import edu.nju.lms.businessLogicService.impl.transport.TransProcessblImpl;
import edu.nju.lms.data.ArrivalState;
import edu.nju.lms.data.ResultMessage;

public class TransportblService_Driver {
	public void drive(TransProcessblService process, TransManageblService manager) {
		
		OrderInforVO order = process.checkOrderInfor("0000000000");
		System.out.println("checkOrderInfor: "+order.getExpressNum());
		
		ArrayList<String> baseInfo = new ArrayList<String>();
		baseInfo.add("张三");
		SendVO send = process.createSendList(new SendVO("0000000000", "0000000000", baseInfo, 1, 1, "goods", 23, 1));
		System.out.println("createSendList:"+send.getPrice());
		
		ResultMessage result1 = process.saveSendList(send);
		System.out.println("saveSendList:"+result1.isSuccess());
		
		ArrayList<String> commodityNums = new ArrayList<String>();
		commodityNums.add("0000000000");
		commodityNums.add("0000000001");
		LoadVO load = process.createLoadList(new LoadVO("0000000000", "2015/01/02", "0250101", "0000000000", "0250102", "010101", "01",commodityNums , 23));
		System.out.println("createLoadList:"+load.getDriverNum());
		
		ResultMessage result2 = process.saveLoadList(load);
		System.out.println("saveLoadList:"+result2.isSuccess());
		
		ArrivalVO arrival = process.createArrivalList(ArrivalState.COMPLETE, "0000000000");
		System.out.println("createArrivalList:"+arrival.getDestination());
		
		ResultMessage result3 = process.saveArrivalList(arrival);
		System.out.println("saveArrivalList:"+result3.isSuccess());
		
		DispatchVO dispatch = process.createDispatchList("010101", "niansong");
		System.out.println("createDispatchList:"+dispatch.getDispatchPerson());
		
		ResultMessage result4 = process.saveDispatchList(dispatch);
		System.out.println("saveDispatchList:"+result4.isSuccess());
		
		ResultMessage result5 = process.saveTransportList(null);
		System.out.println("saveTransportList:"+result5.isSuccess());
		
		VehicleVO vehicle = manager.addVehicle(manager.findVehicle("0000000"));
		System.out.println("addVehicle:"+vehicle.getPlateNum());
		
		ResultMessage result6 = manager.saveVehicleInfor(vehicle);
		System.out.println("saveVehicleInfor:"+result6.isSuccess());
		
		ResultMessage result7 = manager.deleteVehicle("00000000");
		System.out.println("deleteVehicle:"+result7.isSuccess());
		
		ResultMessage result8 = manager.updateVehicle(vehicle);
		System.out.println("updateVehicle:"+result8.isSuccess());
		
	}
	
	public static void main(String[] args) {
//		TransManageblService manager = new TransManageblImpl();
//		TransProcessblImpl process = new TransProcessblImpl();
//		TransportblService_Driver driver = new TransportblService_Driver();
//		driver.drive(process, manager);
	}
	
	
}
