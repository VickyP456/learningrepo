package trial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelRead {
	
	public static String[][] excelDataRead(String fileName) throws IOException{
				//step1: set up the excel document path
				File myFile= new File("./data/"+fileName+".xlsx");
				
				FileInputStream fis = new FileInputStream(myFile);
				
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				
				//step2: set up the worksheet
				XSSFSheet ws = wb.getSheet("Sheet1");
				
				//to find the number of rows in the worksheet
				int rowCount = ws.getLastRowNum();
					
				//to find the number of cells in a row
				int cellCount = ws.getRow(1).getLastCellNum();
				
				//declare 2D array
				String[][] data = new String[rowCount][cellCount];
				
						
				for (int i = 1; i <= rowCount; i++) {					
					for (int j = 0; j < cellCount; j++) {
						String text = ws.getRow(i).getCell(j).getStringCellValue();
						System.out.println(text);
						data[i-1][j] = text;						
					}
				}
				return data;
	}

}