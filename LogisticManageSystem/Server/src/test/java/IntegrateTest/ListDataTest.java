package IntegrateTest;

import java.rmi.RemoteException;

import org.junit.Test;

import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.ListDataService;

public class ListDataTest {
	ListDataService listData;
	ResultMessage success = new ResultMessage(true,null);
	
	@Test
	public void testAddList() throws RemoteException{
	}
	
}
