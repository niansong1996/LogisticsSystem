package simpletest;

import java.lang.reflect.Field;

import edu.nju.lms.PO.AccountPO;

public class Demo3 {

	public static void main(String[] args) throws IllegalAccessException {
		AccountPO object = new AccountPO("6225887941959874",1212343.5);
		String className = AccountPO.class.getName();
		
		String[] classSatter = className.split("\\.");
		String poName = classSatter[classSatter.length-1];
		String result = "insert into "+poName+" value(NULL";
		try {
			object = (AccountPO) Class.forName(className).cast(object);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field[] field = object.getClass().getDeclaredFields();
		try {
			
		for (int j = 1; j < field.length; j++) {
				Field fd1 = object.getClass().getDeclaredField(field[j].getName());
				fd1.setAccessible(true);
				System.out.println(fd1.getType()+" "+fd1.getName());
		}
		result+=");";
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		System.out.println(result);

	}

}
