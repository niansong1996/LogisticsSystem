package edu.nju.lms.presentation.setText;

import edu.nju.lms.VO.ArrivalVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 *@author tj
 *@date 2015年12月13日
 */
public class ArrivalText extends Text {
	private String id;
	private TransportController control;
	public ArrivalText(String id){
		this.id = id;
	}
	@Override
	public String get(UIController controller) {
		this.control = controller.getTransportController();
		String result="\n";
		ArrivalVO vo = control.findArrivalList(id);
		if(vo!=null){
			result+="  单据编号："+vo.getId()+"\n";
			result+="  快递编号："+vo.getExpressNum()+"\n";
			result+="  到达状态："+vo.getArrivalState()+"(什么意思...意会就好)"+"\n";
			result+="  目的地："+vo.getDestination()+"\n";
			result+="  出发地："+vo.getSetOut()+"\n";
			result+="  到达日期："+vo.getArrivalDate()+"\n";
			result+="  中转中心编号："+vo.getTransitNum()+"\n";
		}
		return result;
	}

}
