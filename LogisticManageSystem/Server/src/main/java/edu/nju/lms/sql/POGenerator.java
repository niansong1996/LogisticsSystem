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
		String superClass[] = cls.getSuperclass().getName().split("\\.");
		String lastPkg = superClass[superClass.length-1];
		try {
			if(isList(cls)){
				result = generateListObject(cls,rs);
			}else if(isContainer(cls)){
				result = generateContainerObject(cls,rs);
			}else{
				result = generateDataObject(cls,rs);
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static Object generateDataObject(Class<?> cls,ResultSet rs) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException{
		Object result = null;
		Constructor<?> cons[] = cls.getConstructors();  
		Constructor<?> constructor = cons[0];
		int paraNum = constructor.getParameterCount();
		
			if(rs.next())
				switch(paraNum){
				case 1: result = constructor.newInstance(rs.getString(2));break;
				case 2: result = constructor.newInstance(rs.getString(2),rs.getString(3));break;
				case 3: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4));break;
				case 4: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));break;
				case 5: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));break;
				}
			return result;
	}
	
	
	public static Object generateListObject(Class<?> cls,ResultSet rs){
		return null;
	}
	
	public static Object generateContainerObject(Class<?> cls,ResultSet rs){
		return null;
	}
	public static boolean isList(Class<?> cls){
		if(cls.getSimpleName().equals("ListPO")) return true;
		return false;
	}
	public static boolean isContainer(Class<?> cls){
		Field[] field = cls.getDeclaredFields();
		try {
		for (int j = 0; j < field.length; j++) {
				Field fd1 = cls.getDeclaredField(field[j].getName());
				fd1.setAccessible(true);
				Class<?> type = field[j].getType();
				try{
				if(type.getSuperclass().getSuperclass().getSimpleName()
						.equals("AbstractCollection")){
				return true;	
				}
				}catch(NullPointerException e){
					continue;
				}
		}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return false;
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
		String[] classSatter = className.split("\\.");
		String poName = classSatter[classSatter.length-1];
		String result = "insert into "+poName+" value(NULL";
		try {
			object = Class.forName(className).cast(object);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field[] field = object.getClass().getDeclaredFields();
		try {
			
		for (int j = 1; j < field.length; j++) {
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
