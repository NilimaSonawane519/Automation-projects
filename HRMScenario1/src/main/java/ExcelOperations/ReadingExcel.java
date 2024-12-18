package ExcelOperations;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
	
		String excelfilepath="E:\\Nilima_SeleniumDemos\\HRMScenario2\\Excelfile\\Login1.xlsx";
		FileInputStream inputstream=new FileInputStream(excelfilepath);
		XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=workbook.getSheetAt(0);
		//using for loop
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(1).getLastCellNum();
		
		for(int r=1;r<=rows;r++)
		{
			XSSFRow row=sheet.getRow(r);
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell=row.getCell(c);
				
				if (cell != null) {
				    String value = cell.getStringCellValue();
				    System.out.print(value);
				} else {
				    System.out.println("Cell is null!");
				}

				
				System.out.println();
			}
		}
	}

}
