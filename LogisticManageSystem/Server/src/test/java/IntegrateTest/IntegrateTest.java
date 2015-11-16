package IntegrateTest;

import org.junit.Assert;
import org.junit.Test;

public class IntegrateTest {
int a = 1;
int b;
int c;
public IntegrateTest(){
	b = 2;
}
@Test
public void test1(){
	c = 3;
	Assert.assertEquals(b,2*a);
}
@Test
public void test2(){
	Assert.assertEquals(3, c);
}
}
