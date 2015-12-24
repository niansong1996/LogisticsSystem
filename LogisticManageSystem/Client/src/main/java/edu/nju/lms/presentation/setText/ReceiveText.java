package edu.nju.lms.presentation.setText;

import edu.nju.lms.VO.ReceiveVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController.UIController;

/**
 *@author tj
 *@date 2015年12月13日
 */
public class ReceiveText extends Text {
	private String id;
	private TransportController control;
	public ReceiveText(String id) {
		this.id = id;
	}

	@Override
	public String get(UIController controller) {
		this.control = controller.getTransportController();
		String result="\n";
		ReceiveVO vo = (ReceiveVO) control.findReceiveList(id);
		if(vo!=null){
			result+="  单据编号："+vo.getId()+"\n";
			result+="  快递编号："+vo.getExpressNum()+"\n";
			result+="  收件人姓名："+vo.getReceiverName()+"\n";
			result+="  收件时间："+vo.getReceiveTime()+"\n";
		}
		return result;
	}

}
