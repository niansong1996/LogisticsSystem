package IntegrateTest;

import org.junit.Assert;
import org.junit.Test;

public class IntegrateTest {
int a = 1;
int b =2;
@Test
public void test(){
	Assert.assertEquals(b,2*a);
}
}
