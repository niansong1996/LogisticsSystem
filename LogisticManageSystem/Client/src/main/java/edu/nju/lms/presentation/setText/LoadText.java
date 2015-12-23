package edu.nju.lms.presentation.setText;

import edu.nju.lms.VO.EnumTransformer;
import edu.nju.lms.VO.LoadVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 *@author tj
 *@date 2015年12月13日
 */
public class LoadText extends Text {
	private String id;
	private TransportController control;
	public LoadText(String id){
		this.id = id;
	}
	@Override
	public String get(UIController controller) {
		this.control = controller.getTransportController();
		String result="\n";
		LoadVO vo = control.findLoadList(id);
		if(vo!=null){
			String type = EnumTransformer.loadType2Str(vo.getLoadType());
			result+="  单据编号："+vo.getId()+"\n";
			result+="  装运种类："+type+"\n";
			result+="  装运日期："+vo.getLoadDate()+"\n";
			result+="  营业厅编号："+vo.getBusinessHallNum()+"\n";
			result+="  汽运编号："+vo.getMotorNum()+"\n";
			result+="  目的地营业厅编号："+vo.getDestiBusinessHall()+"\n";
			result+="  目的地城市："+vo.getDestiCity()+"\n";
			result+="  车辆代号："+vo.getVehicleNum()+"\n";
			result+="  司机编号："+vo.getDriverNum()+"\n";
			result+="  运费："+vo.getFreight()+"\n";
			if(vo.getCommodityNums()!=null)
			result+="  本次装运快递数目："+vo.getCommodityNums().size()+"\n";
		}
		return result;
	}

}
