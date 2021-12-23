package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {


	public LinkedHashMap<String, String> readExcel(String filePath,String fileName,String sheetName) throws IOException{

		//Create an object of File class to open xlsx file

		File file =    new File(filePath+"\\"+fileName);

		//Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook wb = null;

		//Find the file extension by splitting file name in substring  and getting only extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		//Check condition if the file is xlsx file

		if(fileExtensionName.equals(".xlsx")){
			//If it is xlsx file then create object of XSSFWorkbook class

			wb = new XSSFWorkbook(inputStream);

		}

		//Check condition if the file is xls file

		else if(fileExtensionName.equals(".xls")){

			//If it is xls file then create object of HSSFWorkbook class

			wb = new HSSFWorkbook(inputStream);

		}

		//Read sheet inside the workbook by its name

		Sheet sheet = wb.getSheet(sheetName);

		//Find number of rows in excel file

		int rowCount = sheet.getLastRowNum();

		LinkedHashMap<String, String> map= new LinkedHashMap<String, String>();

		//Create a loop over all the rows of excel file to read it
		for (int i = 0; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			String key= row.getCell(0).getStringCellValue().trim();
			String value=row.getCell(1).getStringCellValue().trim();

			map.put(key, value);

		} 
		System.out.println(map);
		return map;
	}  

	//Main function is calling readExcel function to read data from excel file

	public static void main(String...strings) throws IOException{

		//Create an object of ExcelDataReader class
		ExcelDataReader objExcelFile = new ExcelDataReader();

		//Prepare the path of excel file

		String filePath = System.getProperty("user.dir");

		//Call read file method of the class to read data

		objExcelFile.readExcel(filePath,"ExcelTest.xlsx","POC");

	}

}

