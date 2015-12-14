package edu.nju.lms.presentation.setText;

import edu.nju.lms.VO.DispatchVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 *@author tj
 *@date 2015年12月13日
 */
public class DispatchText extends Text {
	private String id;
	private TransportController control;
	public DispatchText(String id){
		this.id = id;
	}
	@Override
	public String get(UIController controller) {
		this.control = controller.getTransportController();
		String result="\n";
		DispatchVO vo = control.findDispatchList(id);
		if(vo!=null){
			result+="  单据编号："+vo.getId()+"\n";
			result+="  派件人："+vo.getDispatchPerson()+"\n";
			result+="  派件日期："+vo.getArrivalDate()+"\n";
			result+="  快递编号："+vo.getExpressNum()+"\n";
		}
		return result;
	}

}
