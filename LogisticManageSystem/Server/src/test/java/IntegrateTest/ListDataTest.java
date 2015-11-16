package IntegrateTest;

import java.rmi.RemoteException;

import org.junit.Test;

import edu.nju.lms.data.ListState;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.ListDataService;
import edu.nju.lms.dataService.impl.ListDataImpl;
import junit.framework.Assert;

public class ListDataTest {
	ListDataService listData = new ListDataImpl();
	ResultMessage success = new ResultMessage(true,null);
	
	@Test
	public void testAddList() throws RemoteException{
		Assert.assertEquals(success,listData.updateList("8374627232", ListState.WAITING));
		
	}
	
}
