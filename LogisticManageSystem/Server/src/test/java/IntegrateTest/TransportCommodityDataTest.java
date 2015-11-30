package IntegrateTest;

import java.rmi.RemoteException;

import org.junit.Assert;
import org.junit.Test;

import edu.nju.lms.PO.CommodityPO;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.ShipState;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.dataService.TransportCommodityDataService;
import edu.nju.lms.dataService.impl.TransportCommodityDataImpl;

public class TransportCommodityDataTest {
	TransportCommodityDataService transportCommodityData;
	
	CommodityPO commodityPo1 = new CommodityPO("7876354637","RECEIPIENT","9837463526","[9837463526]","[9837463526]","9837463526","[9837463526]","[9837463526]","9837463526");
	CommodityPO commodityPo2 = new CommodityPO("3984534242","DISPATCHING","9837463526","[9837463526]","[9837463526]","9837463526","[9837463526]","[9837463526]","9837463526");
	
	ResultMessage success = new ResultMessage(true,null);
	ResultMessage fail1 = new ResultMessage(false,"The commodity already exists!");
	ResultMessage fail2 = new ResultMessage(false,"Could not find the commodity!");
	
	@Test
	public void testAddCommodity() throws RemoteException{
		transportCommodityData = new TransportCommodityDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table commoditypo");
		Assert.assertEquals(success,transportCommodityData.addCommodity(commodityPo1));
		Assert.assertEquals(fail1,transportCommodityData.addCommodity(commodityPo1));
		Assert.assertEquals(success, transportCommodityData.addCommodity(commodityPo2));
	}
	@Test
	public void testDeleteCommodity() throws RemoteException{
		transportCommodityData = new TransportCommodityDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table commoditypo");
		transportCommodityData.addCommodity(commodityPo1);
		Assert.assertEquals(success, transportCommodityData.deleteCommodity(commodityPo1.getId()));
		Assert.assertEquals(fail2, transportCommodityData.deleteCommodity(commodityPo1.getId()));
	}
	@Test
	public void testFindCommodity() throws RemoteException{
		transportCommodityData = new TransportCommodityDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table commoditypo");
		transportCommodityData.addCommodity(commodityPo2);
		Assert.assertEquals(commodityPo2, transportCommodityData.findCommodity(commodityPo2.getId()));
		Assert.assertEquals(null, transportCommodityData.findCommodity(commodityPo1.getId()));
		
	}
	@Test
	public void testUpdateCommodity() throws RemoteException{
		transportCommodityData = new TransportCommodityDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table commoditypo");
		transportCommodityData.addCommodity(commodityPo2);
		Assert.assertEquals(success,transportCommodityData.updateCommodity(commodityPo2));
		Assert.assertEquals(fail2, transportCommodityData.updateCommodity(commodityPo1));
	}
}
