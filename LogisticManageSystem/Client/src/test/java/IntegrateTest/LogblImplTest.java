package IntegrateTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.businessLogicService.impl.log.LogblImpl;
import edu.nju.lms.data.ResultMessage;
import junit.framework.Assert;

public class LogblImplTest {
	
	LogblImpl logImpl = new LogblImpl();

	@Test
	public void testGetInfo() {
		Calendar begin = Calendar.getInstance();
		begin.set(2015, 5, 12);
		Calendar end = Calendar.getInstance();
		end.set(2015, 5, 13);
		ArrayList<OperationVO> log = new ArrayList<OperationVO>();
		OperationVO operation = new OperationVO("add check out list","2015/5/12","0251011001");
		log.add(operation);
		logImpl.addLog(operation);
		Assert.assertEquals(operation, logImpl.getLogInfo(begin, end).get(0));
	}
	
	@Test
	public void testAdd() {
		OperationVO operation = new OperationVO("add check out list","2015/5/12","0251011001");
		ResultMessage message = logImpl.addLog(operation);
		if(!message.isSuccess()) {
			fail(message.getErrorMessage());
		}
	}

}
