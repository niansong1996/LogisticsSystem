package IntegrateTest;

import java.rmi.RemoteException;

import junit.framework.Assert;

import org.junit.Test;

import edu.nju.lms.PO.ListPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.ListDataService;
import edu.nju.lms.dataService.impl.ListDataImpl;

public class ListDataTest {
	ListDataService listData = new ListDataImpl();
	ResultMessage success = new ResultMessage(true,null);
	
	@Test
	public void testAddList() throws RemoteException{
		ListPO po=null;
		Assert.assertEquals(success,listData.updateList(po));
		
	}
	
}
