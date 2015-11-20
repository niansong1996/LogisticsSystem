package edu.nju.lms.sql;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class POGenerator {
	public static Object generateObject(ResultSet rs,String className){
		Class<?> cls = null;
		Object result = null;
		try {
			cls = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Constructor<?> cons[] = cls.getConstructors();  
		Constructor<?> constructor = cons[1];
		int paraNum = constructor.getParameterCount();
		try {
			if(rs.next())
				
				switch(paraNum){
				case 1: result = constructor.newInstance(rs.getString(2));break;
				case 2: result = constructor.newInstance(rs.getString(2),rs.getString(3));break;
				case 3: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4));break;
				case 4: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));break;
				case 5: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));break;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static String generateUpdateOp(Object object ,String className){
//		System.out.println(className);
		
//"update userpo set userName=\""+user.getUserName()+"\",password=\""+user.getPassword()+"\",power=\""+user.getPower()+"\" where userName=\""+user.getUserName()+"\";"
		String[] classSatter = className.split("\\.");
		String poName = classSatter[classSatter.length-1];
		String result = "update "+poName+" set ";
		try {
			object = Class.forName(className).cast(object);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		System.out.println(object.getClass().getName());
		Field[] field = object.getClass().getDeclaredFields();
		try {
			
		for (int j = 1; j < field.length; j++) {
//			Class<?> type = field[j].getType();   field[j].getName() +
			if(j!=0) result+=", ";
				Field fd1 = object.getClass().getDeclaredField(field[j].getName());
				fd1.setAccessible(true);
				result += field[j].getName()+"=\""+ fd1.get(object)+"\" ";
		}
		Field fd2 = object.getClass().getDeclaredField(field[0].getName());
		fd2.setAccessible(true);
		result+="where "+field[0].getName()+"=\""+fd2.get(object)+"\";";
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	public static String generateInsertOp(Object object ,String className){
//		System.out.println(className);
		
// "insert into userpo value(NULL,\""+user.getUserName()+"\",\""+user.getPassword(+"\",\""+user.getPower()+"\");"
		String[] classSatter = className.split("\\.");
		String poName = classSatter[classSatter.length-1];
		String result = "insert into "+poName+" value(NULL";
		try {
			object = Class.forName(className).cast(object);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		System.out.println(object.getClass().getName());
		Field[] field = object.getClass().getDeclaredFields();
		try {
			
		for (int j = 1; j < field.length; j++) {
//			Class<?> type = field[j].getType();   field[j].getName() +

				Field fd1 = object.getClass().getDeclaredField(field[j].getName());
				fd1.setAccessible(true);
				result += ", \""+ fd1.get(object)+"\"";
		}
		result+=");";
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}
}
