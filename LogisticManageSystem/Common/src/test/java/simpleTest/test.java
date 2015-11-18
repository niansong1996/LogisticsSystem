package simpleTest;

import org.junit.Test;

import edu.nju.lms.data.ResultMessage;
import junit.framework.Assert;

public class test {
	ResultMessage result1 = new ResultMessage(true,null);
	ResultMessage result2 = new ResultMessage(true,null);
	ResultMessage result3 = new ResultMessage(true,"yes");
	ResultMessage result4 = new ResultMessage(false,"yes");
	ResultMessage result5 = new ResultMessage(false,"yes");
	ResultMessage result6 = new ResultMessage(false,"no");
	
	@Test
	public void test1(){
		Assert.assertEquals(result1, result2);
		}
	@Test
	public void test2(){
		Assert.assertEquals(result3, result4);
	}
	@Test
	public void test3(){
		Assert.assertEquals(result5, result6);
	}
	@Test
	public void test4(){
		Assert.assertEquals(result4, result5);
	}
	@Test
	public void test5(){
		Assert.assertEquals(result5, result6);
	}
}
