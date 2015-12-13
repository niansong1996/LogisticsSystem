package edu.nju.lms.presentation.setText;

import edu.nju.lms.VO.CheckinVO;
import edu.nju.lms.businessLogicService.impl.warehouse.WarehouseController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 *@author tj
 *@date 2015年12月13日
 */
public class CheckinText extends Text {
	private String id;
	private WarehouseController control;
	public CheckinText(String id){
		this.id = id;
	}
	@Override
	public String get(UIController controller) {
		this.control = controller.getWarehouseController();
		String result="\n";
		CheckinVO vo = control.findCheckinList(id);
		if(vo!=null){
			result+="  单据编号："+vo.getId()+"\n";
			result+="  本次入库快递个数："+vo.getExpresses().size()+"\n";
		}
		return result;
	}

}
