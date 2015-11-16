package IntegrateTest;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import edu.nju.lms.VO.CityVO;
import edu.nju.lms.VO.DepartmentVO;
import edu.nju.lms.businessLogicService.impl.department.DepartmentController;
import edu.nju.lms.data.DepartmentType;
import edu.nju.lms.data.ResultMessage;
/**
 * 
 * @author oppalu
 * 2015/11/16
 *
 */
public class DepartmentblImplTest {

	DepartmentController departmentController=new DepartmentController();
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAddDepartment(){
		DepartmentVO department1=new DepartmentVO(DepartmentType.BUSINESSHALL,"025123","025");
		DepartmentVO department2=new DepartmentVO(DepartmentType.TRANSITCENTER,"025023","025");
		
		ResultMessage addResult1=departmentController.addDepartment(department1);
		ResultMessage addResult2=departmentController.addDepartment(department2);
		ResultMessage addResult3=departmentController.addDepartment(department1);
		
		Assert.assertEquals(true, addResult1.isSuccess());
		Assert.assertEquals(true, addResult2.isSuccess());
		Assert.assertEquals(false, addResult3.isSuccess());
	}
	
	@Test
	public void testDeleteDepartment(){
		ResultMessage deleteResult1=departmentController.deleteDepartment("025023");
		ResultMessage deleteResult2=departmentController.deleteDepartment("025000");
		
		Assert.assertEquals(true, deleteResult1.isSuccess());
		Assert.assertEquals(false, deleteResult2.isSuccess());
	}

	@Test
	public void testUpdateDepartment(){
		DepartmentVO department1=new DepartmentVO(DepartmentType.BUSINESSHALL,"025121","025");
		DepartmentVO department2=new DepartmentVO(DepartmentType.BUSINESSHALL,"001121","001");
		ResultMessage updateResult1=departmentController.updateDepartment(department1);
		ResultMessage updateResult2=departmentController.updateDepartment(department2);
		
		Assert.assertEquals(true, updateResult1.isSuccess());
		Assert.assertEquals("未找到城市", updateResult2.getErrorMessage());
	}
	
	@Test
	public void testGetDepartInfo(){
		DepartmentVO department=departmentController.getDepartInfo("025121");
		System.out.println(department.getType()+" "+department.getDepartmentNum()+" "+department.getLocation());
	}
	
	@Test
	public void testAddCity(){
		ArrayList<String> businessNums=new ArrayList<String>();
		businessNums.add("025617");
		ArrayList<Double> distance=new ArrayList<Double>();
		distance.add(1234.5);
		
		CityVO city1=new CityVO("025","Nanjing",businessNums,distance);
		CityVO city2=new CityVO("010","Beijing",businessNums,distance);
		
		ResultMessage cityResult1=departmentController.addCity(city1);
		ResultMessage cityResult2=departmentController.addCity(city2);
		ResultMessage cityResult3=departmentController.addCity(city1);
		
		Assert.assertEquals(true, cityResult1.isSuccess());
		Assert.assertEquals(true, cityResult2.isSuccess());
		//TODO
		Assert.assertEquals("城市已存在", cityResult3.getErrorMessage());
	}
	
	@Test
	public void testFindCity(){
		CityVO city3=departmentController.findCity("025");
		Assert.assertEquals("Nanjing", city3.getName());
		
		CityVO city4=departmentController.findCity("001");
		Assert.assertEquals("未找到城市", city4.getName());
	}
}
