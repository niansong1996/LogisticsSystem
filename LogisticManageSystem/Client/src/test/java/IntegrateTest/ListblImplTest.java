package IntegrateTest;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import edu.nju.lms.VO.ListVO;
import edu.nju.lms.businessLogicService.impl.list.ListController;
import edu.nju.lms.data.ListType;

/**
 * @author oppalu
 * 2015/11/16
 *
 */
public class ListblImplTest {
	
	ListController listController=new ListController();

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetListInfo(){
		ArrayList<ListVO> list=listController.getListInfo(ListType.ARRIVAL);
		System.out.println("**********start testing getListInfo**********");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getId()+" "+list.get(i).getType()+" "+list.get(i).getState());
		}
		System.out.println("**********end testing**********");
	}
	
	@Test
	public void testChangeList(){
		//TODO
		//don't know some existent list info
	}

}
