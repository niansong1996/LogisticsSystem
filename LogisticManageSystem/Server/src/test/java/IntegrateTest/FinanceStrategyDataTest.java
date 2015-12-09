package IntegrateTest;

import java.rmi.RemoteException;

import org.junit.Test;

import edu.nju.lms.PO.PriceStrategyPO;
import edu.nju.lms.PO.SalaryStrategyPO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.data.utility.JDBC;
import edu.nju.lms.dataService.FinanceStrategyDataService;
import edu.nju.lms.dataService.impl.FinanceStrategyDataImpl;
import junit.framework.Assert;

public class FinanceStrategyDataTest {
	public FinanceStrategyDataService financeStrategyData;
	public PriceStrategyPO  priceStrategyPO1 = new PriceStrategyPO(23.5);
	public PriceStrategyPO  priceStrategyPO2 = new PriceStrategyPO(15.6);
	
	public SalaryStrategyPO  salaryStrategyPO1 = new SalaryStrategyPO(PersonType.ADMINISTRATOR,6000,30,2000);
	public SalaryStrategyPO  salaryStrategyPO2 = new SalaryStrategyPO(PersonType.COUNTER_INTERMEDIATE,3000,25,500);
	
	public ResultMessage success1 = new ResultMessage(true,"success");
	public ResultMessage fail11 = new ResultMessage(false,"The price strategy already exists!");
	public ResultMessage fail12 = new ResultMessage(false,"Could not find the price strategy!");
	
	public ResultMessage success2 = new ResultMessage(true,"success");
	public ResultMessage fail21 = new ResultMessage(false,"The salary strategy already exists!");
	public ResultMessage fail22 = new ResultMessage(false,"Could not find the salary strategy!");
	
	@Test
	public void testAddPriceStrategy() throws RemoteException{
		financeStrategyData = new FinanceStrategyDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table priceStrategypo");
		JDBC.ExecuteData("truncate table salaryStrategypo");
		Assert.assertEquals(success1, financeStrategyData.addPriceStrategy(priceStrategyPO1));
		Assert.assertEquals(fail11, financeStrategyData.addPriceStrategy(priceStrategyPO1));
		Assert.assertEquals(fail11, financeStrategyData.addPriceStrategy(priceStrategyPO2));
	}
	@Test
	public void testUpdatePriceStrategy() throws RemoteException{
		financeStrategyData = new FinanceStrategyDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table priceStrategypo");
		JDBC.ExecuteData("truncate table salaryStrategypo");
		Assert.assertEquals(fail12, financeStrategyData.updatePriceStrategy(priceStrategyPO2));
		financeStrategyData.addPriceStrategy(priceStrategyPO2);
		Assert.assertEquals(success1, financeStrategyData.updatePriceStrategy(priceStrategyPO2));
	}
	@Test
	public void testFindPriceStrategy() throws RemoteException{
		financeStrategyData = new FinanceStrategyDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table priceStrategypo");
		JDBC.ExecuteData("truncate table salaryStrategypo");
		Assert.assertEquals(null, financeStrategyData.findPriceStrategy());
		financeStrategyData.addPriceStrategy(priceStrategyPO2);
		Assert.assertEquals(priceStrategyPO2, financeStrategyData.findPriceStrategy());
	}
	@Test
	public void testAddSalaryStrategy() throws RemoteException{
		financeStrategyData = new FinanceStrategyDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table priceStrategypo");
		JDBC.ExecuteData("truncate table salaryStrategypo");
		Assert.assertEquals(success2, financeStrategyData.addSalaryStrategy(salaryStrategyPO1));
		Assert.assertEquals(fail21, financeStrategyData.addSalaryStrategy(salaryStrategyPO1));
		Assert.assertEquals(success2, financeStrategyData.addSalaryStrategy(salaryStrategyPO2));
	}	
	@Test
	public void testUpdateSalaryStrategy() throws RemoteException{
		financeStrategyData = new FinanceStrategyDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table priceStrategypo");
		JDBC.ExecuteData("truncate table salaryStrategypo");
		Assert.assertEquals(fail22, financeStrategyData.updateSalaryStrategy(salaryStrategyPO2));
		financeStrategyData.addSalaryStrategy(salaryStrategyPO2);
		Assert.assertEquals(success2, financeStrategyData.updateSalaryStrategy(salaryStrategyPO2));
	}
	@Test
	public void testFindSalaryStrategy() throws RemoteException{
		financeStrategyData = new FinanceStrategyDataImpl();
		JDBC.createJDBC("jdbc:mysql://127.0.0.1:3306/lms","root","9990");
		JDBC.ExecuteData("truncate table priceStrategypo");
		JDBC.ExecuteData("truncate table salaryStrategypo");
		Assert.assertEquals(null, financeStrategyData.findSalaryStrategy(PersonType.ADMINISTRATOR));
		financeStrategyData.addSalaryStrategy(salaryStrategyPO2);
		Assert.assertEquals(salaryStrategyPO2, financeStrategyData.findSalaryStrategy(PersonType.COUNTER_INTERMEDIATE));
	}
}
