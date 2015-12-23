package IntegrateTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.data.ListType;

/**
 * @author oppalu
 * 2015/11/16
 *
 */
public class ListblImplTest {
	
	ListController listController=BusinessLogicFactory.createListController();

	@Test
	public void testGetListInfo(){
		
	}

	@Test
	public void testGetList(){
		ArrayList<ListVO> result=listController.getListInfo(ListType.RECEIPT);
		Assert.assertEquals(expected, actual);
	}
}
