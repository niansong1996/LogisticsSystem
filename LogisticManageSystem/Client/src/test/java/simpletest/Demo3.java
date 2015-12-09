package simpletest;

import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Demo3 {
   
	public static final String CLIENT = "../../Documentations/Metrics_Client.xml";
	public static final String COMMON = "../../Documentations/Metrics_Common.xml";
	public static final String SERVER = "../../Documentations/Metrics_Server.xml";
	public static void main(String[] args){
		try {
			getExcel(CLIENT);
			getExcel(COMMON);
			getExcel(SERVER);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void getExcel(String type) throws Exception{
		Statisitic sta = new Statisitic(type);
		// 第一步，创建一个webbook，对应一个Excel文件  
		HSSFWorkbook wb = new HSSFWorkbook();  
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
		HSSFSheet sheet = wb.createSheet("度量数据");  
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
		HSSFRow row = sheet.createRow((int) 0);  
		// 第四步，创建单元格，并设置值表头 设置表头居中  
		HSSFCellStyle style = wb.createCellStyle();  
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  

		HSSFCell cell = row.createCell(0);  
		cell.setCellValue("类名");  
		cell.setCellStyle(style);  
		
		cell = row.createCell(1);  
		cell.setCellValue("代码行数LOC");  
		cell.setCellStyle(style); 
		
		cell = row.createCell(2);  
		cell.setCellValue("所属包传入耦合CA");  
		cell.setCellStyle(style);  
		
		cell = row.createCell(3);  
		cell.setCellValue("所属包传出耦合CE");  
		cell.setCellStyle(style); 
		
		cell = row.createCell(4);  
		cell.setCellValue("子类数量NOC");  
		cell.setCellStyle(style);
		
		cell = row.createCell(5);  
		cell.setCellValue("继承深度DIT");  
		cell.setCellStyle(style);
		
		cell = row.createCell(6);  
		cell.setCellValue("方法行数LCOM");  
		cell.setCellStyle(style);
		
		cell = row.createCell(7);  
		cell.setCellValue("圈复杂度VG");  
		cell.setCellStyle(style);

		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
		Iterator<ClassInfo> it = sta.startStatistic();  

		for (int i = 0;it.hasNext(); i++)  
		{  
			ClassInfo cls = it.next();
			row = sheet.createRow(i+1);  
			row.createCell(0).setCellValue(cls.name.split("\\{")[1].split("\\[")[0].split("\\.")[0]);  
			row.createCell(1).setCellValue(cls.lineOfCode);  
			row.createCell(2).setCellValue(cls.CA);
			row.createCell(3).setCellValue(cls.CE);
			row.createCell(4).setCellValue(cls.NOC);
			row.createCell(5).setCellValue(cls.DIT);
			row.createCell(6).setCellValue(cls.LCOM);
			row.createCell(7).setCellValue(cls.VG);
		}  
		// 第六步，将文件存到指定位置  
		try  
		{  
			FileOutputStream fout = new FileOutputStream("target/"+type.split("\\/")[3].split("\\.")[0].split("_")[1]+"_Measurement.xls");  
			wb.write(fout);  
			fout.close();  
		}  
		catch (Exception e)  
		{  
			e.printStackTrace();  
		}   
	}
}
