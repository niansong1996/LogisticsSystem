package IntegrateTest;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;

import edu.nju.lms.VO.OperationVO;
import edu.nju.lms.businessLogicService.impl.log.LogblImpl;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.LogDataService;

public class LogblImplTest {
	
	LogDataService logData;
	LogblImpl logImpl = new LogblImpl(logData);

	@Test
	public void testGetInfo() {
		Calendar begin = Calendar.getInstance();
		begin.set(2015, 5, 12);
		Calendar end = Calendar.getInstance();
		end.set(2015, 5, 13);
		ArrayList<OperationVO> log = new ArrayList<OperationVO>();
		OperationVO operation = new OperationVO("2015/5/12","0251011001","add check out list");
		log.add(operation);
		logImpl.addLog(operation);
		Assert.assertEquals(operation, logImpl.getLogInfo(begin, end).get(0));
	}
	
	@Test
	public void testAdd() {
		OperationVO operation = new OperationVO("2015/5/12","0251011001","add check out list");
		ResultMessage message = logImpl.addLog(operation);
		if(!message.isSuccess()) {
			fail(message.getErrorMessage());
		}
	}

}
