package edu.nju.lms.presentation.setText;

import edu.nju.lms.VO.SendVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 * @author tj
 * @date 2015年12月13日
 */
public class SendText extends Text {
	private String id;
	private TransportController control;

	public SendText(String id) {
		this.id = id;
	}

	@Override
	public String get(UIController controller) {
		this.control = controller.getTransportController();
		String result="\n";
		SendVO vo = control.findSendListById(id);
		if(vo!=null){
			result+="  单据编号："+vo.getId()+"\n";
			result+="  快递单号："+vo.getExpressNum()+"\n";
			result+="  打包方式:"+vo.getPackingType()+"(意会就好...)\n";
			result+="  报价："+vo.getPrice()+"\n";
			result+="  寄件日期："+vo.getCreateTime()+"\n";
		}
		return result;
	}

}
