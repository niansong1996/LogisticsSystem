package edu.nju.lms.data.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class POGenerator {
	public static Object generateObject(ResultSet rs,String className){
		Class<?> cls = null;
		Object result = null;
		try {
			cls = Class.forName(className);
			result = generateDataObject(cls,rs);

		} catch (Exception e) {
			System.out.println("Generate PO failed!!");
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
			case 6: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));break;
			case 7: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));break;
			case 8: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));break;
			case 9: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));break;
			case 10: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));break;
			}
		return result;
	}


	public static void generateMultiObject(List list,ResultSet rs, String className){
		Class<?> cls = null;
		try {
			cls = Class.forName(className);
			Object result = null;
			Constructor<?> cons[] = cls.getConstructors();  
			Constructor<?> constructor = cons[0];
			int paraNum = constructor.getParameterCount();

			while(rs.next()){
				switch(paraNum){
				case 1: result = constructor.newInstance(rs.getString(2));break;
				case 2: result = constructor.newInstance(rs.getString(2),rs.getString(3));break;
				case 3: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4));break;
				case 4: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));break;
				case 5: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));break;
				case 6: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));break;
				case 7: result = constructor.newInstance(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));break;
				}
				list.add(cls.cast(result));
			}

		} catch (Exception e) {
			System.out.println("Generate PO failed!!");
			e.printStackTrace();
		}
	}

	public static Object generateContainerObject(Class<?> cls,ResultSet rs){
		return null;
	}
	public static boolean isList(Class<?> cls){
		if(cls.getSuperclass().getSimpleName().equals("ListPO")) return true;
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
				}catch(NullPointerException e){continue;}
			}} catch (Exception e) {
				System.out.println("Get field elements failed!!!");
				e.printStackTrace();
			}
		return false;
	}

	public static String generateUpdateOp(Object object ,String className){
		String[] classSatter = className.split("\\.");
		String poName = classSatter[classSatter.length-1];
		String result = "update "+poName+" set ";
		try {
			object = Class.forName(className).cast(object);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field[] field = object.getClass().getDeclaredFields();
		try {

			if(isList(object.getClass())){
				Field[] fatherField = object.getClass().getFields();
				Field fd1;
				fd1 = object.getClass().getField(fatherField[0].getName());
				fd1.setAccessible(true);
				result += fd1.getName()+"=\""+ fd1.get(object)+"\" ,";
			}

			for (int j = 1; j < field.length; j++) {
				if(j!=1) result+=", ";
				Field fd1 = object.getClass().getDeclaredField(field[j].getName());
				fd1.setAccessible(true);
				if(fd1.getType().getSimpleName().equals("double"))
					result += field[j].getName()+"="+ fd1.get(object)+" ";
				else if(fd1.getType().getSimpleName().equals("integer"))
					result += field[j].getName()+"="+ fd1.get(object)+" ";
				else if(fd1.getType().getSimpleName().equals("Calendar"))
					result += field[j].getName()+"=\""+ Cal2String((Calendar)fd1.get(object)) +"\" ";
				else
					result += field[j].getName()+"=\""+ fd1.get(object)+"\" ";
			}
			Field fd2 = object.getClass().getDeclaredField(field[1].getName());
			if(isList(object.getClass())){
				Field[] fatherField = object.getClass().getFields();
				fd2 = object.getClass().getField(fatherField[0].getName());
			}
			fd2.setAccessible(true);
			result+="where "+fd2.getName()+"=\""+fd2.get(object)+"\";";
		} catch (Exception e) {
			System.out.println("Get field elements failed!!!");
			e.printStackTrace();
		}
		//	System.out.println(result);
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

			if(isList(object.getClass())){
				Field[] fatherField = object.getClass().getFields();
				Field fd1;
				fd1 = object.getClass().getField(fatherField[0].getName());
				fd1.setAccessible(true);
				result += ", \""+ fd1.get(object)+"\"";
			}

			for (int j = 1; j < field.length; j++) {
				Field fd1 = object.getClass().getDeclaredField(field[j].getName());
				fd1.setAccessible(true);
				if(fd1.getType().getSimpleName().equals("double"))
					result += ", "+ fd1.get(object)+"";
				else if(fd1.getType().getSimpleName().equals("integer"))
					result += ", "+ fd1.get(object)+"";
				else if(fd1.getType().getSimpleName().equals("Calendar"))
					result += ",\""+ Cal2String((Calendar)fd1.get(object))+"\"";
				else
					result += ", \""+ fd1.get(object)+"\"";
			}
			result+=");";
		} catch (Exception e) {
			System.out.println("Get field elements failed!!!");
		}
		System.out.println(result);
		return result;
	}

	public static String Cal2String(Object cal){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(((Calendar)cal).getTime());
	}

	public static <T> T[] concat(T[] first, T[] second) {
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}         
}
