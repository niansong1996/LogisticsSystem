package edu.nju.lms.presentation.setText;

import edu.nju.lms.VO.CheckoutVO;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 *@author tj
 *@date 2015年12月13日
 */
public class CheckoutText extends Text {
	private String id;
	private WarehouseController control;
	public CheckoutText(String id){
		this.id = id;
	}
	@Override
	public String get(UIController controller) {
		String result="\n";
		this.control = controller.getWarehouseController();
		CheckoutVO vo = control.findCheckoutList(id);
		if(vo!=null){
			result+="  单据编号："+vo.getId()+"\n";
			result+="  本次出库快递个数："+vo.getExpressNums().size()+"\n";
			result+="  出库时间："+vo.getCheckoutDate()+"\n";
			result+="  装运形式："+vo.getLoadType()+"意思意会就好..."+"\n";
			result+="  到达单编号："+vo.getArrivalNum()+"\n";
			result+="  汽运编号："+vo.getMotorNum()+"\n";
			if(vo.getDestination()!=null)
			result+="  目的地："+vo.getDestination().get(0)+"\n";
		}
		return result;
	}

}
