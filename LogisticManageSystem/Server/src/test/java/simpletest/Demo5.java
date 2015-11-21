package simpletest;

import java.lang.reflect.Field;

import edu.nju.lms.PO.AccountPO;

public class Demo5 {

	public static void main(String[] args) {
		System.out.println(AccountPO.class.getSimpleName());
		Field field[] = AccountPO.class.getDeclaredFields();
		System.out.println(field.length);

	}

}
