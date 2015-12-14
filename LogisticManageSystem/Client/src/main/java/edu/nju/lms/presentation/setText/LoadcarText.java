package edu.nju.lms.presentation.setText;

import edu.nju.lms.VO.LoadCarVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 *@author tj
 *@date 2015年12月13日
 */
public class LoadcarText extends Text{
	private String id;
	private TransportController control;
	public LoadcarText(String id){
		this.id = id;
	}
	@Override
	public String get(UIController controller) {
		this.control = controller.getTransportController();
		String result="\n";
		LoadCarVO vo = control.findLoadCarList(id);
		if(vo!=null){
			result+="  单据编号："+vo.getId()+"\n";
			result+="  装车日期："+vo.getLoadDate()+"\n";
			result+="  营业厅编号"+vo.getBusinessHallNum()+"\n";
			result+="  汽运编号："+vo.getMotorNum()+"\n";
			result+="  目的地营业厅编号："+vo.getDestiBusinessHall()+"\n";
			result+="  车辆代号："+vo.getVehicleNum()+"\n";
			result+="  司机编号："+vo.getDriverNum()+"\n";
			result+="  运费："+vo.getFreight()+"\n";
			if(vo.getCommodityNums()!=null)
			result+="  本次装车快递数目："+vo.getCommodityNums().size()+"\n";
		}
		return result;
	}

}
