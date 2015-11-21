package IntegrateTest;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.nju.lms.VO.PersonnelVO;
import edu.nju.lms.businessLogicService.impl.personnel.PersonnelblImpl;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年11月16日
 */
public class PersonnelblImplTest {
	PersonnelblImpl personbl = new PersonnelblImpl(null);
	@Test
	public void testFindPersonInfo() {
		PersonnelVO person = new PersonnelVO("0251007111","lily","025000","营业厅业务员",0,0,0);
		personbl.addPersonnel(person);
		PersonnelVO result = personbl.findPersonInfo("0251007111");
		assertEquals(result.getDepartmentNum(),"025000");
		assertEquals(result.getName(),"lily");
	}

	@Test
	public void testDeletePersonnel() {
		PersonnelVO person = new PersonnelVO("0251007111","lily","025000","营业厅业务员",0,0,0);
		personbl.addPersonnel(person);
		ResultMessage re = personbl.deletePersonnel("0251007111");
		assertEquals(true,re.isSuccess());
	}

	@Test
	public void testUpdatePersonnel() {
		PersonnelVO person = new PersonnelVO("0251007111","lily","025000","营业厅业务员",0,0,0);
		personbl.addPersonnel(person);
		PersonnelVO person1 = new PersonnelVO("0251007111","lily","025000","营业厅业务员",0,0,0);
		ResultMessage re = personbl.updatePersonnel(person1);
		assertEquals(true,re.isSuccess());
	}

	@Test
	public void testAddPersonnel() {
		PersonnelVO person = new PersonnelVO("0251007111","lily","025000","营业厅业务员",0,0,0);
		ResultMessage re = personbl.addPersonnel(person);
		assertEquals(true,re.isSuccess());
		PersonnelVO person1 = new PersonnelVO("02510","lily","025000","营业厅业务员",0,0,0);
		re = personbl.addPersonnel(person1);
		assertEquals(false,re.isSuccess());
	}

}
