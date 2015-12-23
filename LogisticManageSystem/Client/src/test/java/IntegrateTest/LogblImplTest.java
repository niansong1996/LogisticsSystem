package IntegrateTest;

import org.junit.Assert;
import org.junit.Test;

import edu.nju.lms.businessLogic.BusinessLogicFactory;
import edu.nju.lms.businessLogicService.impl.log.LogController;
import edu.nju.lms.data.ResultMessage;

public class LogblImplTest {
	
	LogController LogController=BusinessLogicFactory.createLogController();

	@Test
	public void testAdd() {
		LogController.setLogId("test");
		ResultMessage resultMessage=LogController.addLog("for test");
		Assert.assertEquals(true, resultMessage.isSuccess());
	}
}
