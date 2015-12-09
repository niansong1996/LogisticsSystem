package edu.nju.lms.businessLogicService.impl.utility;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelExporter {
	public static void exportExcel(String chartName,ArrayList<String> rowArguments) throws Exception{
		HSSFWorkbook wb = new HSSFWorkbook();   
		HSSFSheet sheet = wb.createSheet(chartName);   
		HSSFRow row = sheet.createRow(0);   
		HSSFCellStyle style = wb.createCellStyle();  
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  

		HSSFCell cell;
		for(int i=0;i<rowArguments.size();i++){
			cell = row.createCell(i);  
			cell.setCellValue(rowArguments.get(i));  
			cell.setCellStyle(style);  
		} 
//		List list = Demo3.getStudent();  
//
//		for (int i = 0; i < list.size(); i++)  
//		{  
//			row = sheet.createRow(i+1);  
//			Student stu = (Student) list.get(i);  
//			// 第四步，创建单元格，并设置值  
//			row.createCell(0).setCellValue((double) stu.getId());  
//			row.createCell(1).setCellValue(stu.getName());  
//			row.createCell(2).setCellValue((double) stu.getAge());  
//			cell = row.createCell(3);  
//			cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));  
//		}  
		// 第六步，将文件存到指定位置  
		try  
		{  
			FileOutputStream fout = new FileOutputStream("target/students.xls");  
			wb.write(fout);  
			fout.close();  
		}  
		catch (Exception e)  
		{  
			e.printStackTrace();  
		}   
	}
}
