package edu.nju.lms.presentation.setText;

import java.io.BufferedReader;
import java.io.FileReader;

import edu.nju.lms.VO.OrderInforVO;
import edu.nju.lms.businessLogicService.impl.transport.TransportController;
import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.EnumTransformer;

/**
 * get orderinfo text
 * @author cuihao
 *
 */
public class OrderInfoText extends Text{

	@Override
	public String get(UIController controller) {
		String infoText = "\n";
		TransportController transport = controller.getTransportController();
		String id = null;
		try {
			/**
			 * read commodity number
			 */
			BufferedReader br = new BufferedReader(new FileReader("temp.lms"));
			id = br.readLine();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(id!=null) {
			/**
			 * find info
			 */
			OrderInforVO info = transport.checkOrderInfor(id);
			if(info!=null) {
				infoText+=("  快递编号："+info.getExpressNum()+"\n");
				infoText+=("  快递状态："+EnumTransformer.shipState2Str(info.getShipState())+"\n");
				for(String s:info.getTrack()) {
					infoText+=(s+"\n");
				}
			} else {
				infoText+=("  快递不存在！");
			}
		}else{
			infoText+=("  文件读写错误！");
		}
	
		return infoText;
	}

}
