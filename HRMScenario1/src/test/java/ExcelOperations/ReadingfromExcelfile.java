package ExcelOperations;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingfromExcelfile {
  @Test
  public void ReadData() throws IOException {
	  String fpath="E:\\Nilima_SeleniumDemos\\HRMScenario1\\Excelfile\\logindata1.xlsx";
	  
	  File file=new File(fpath);
	  FileInputStream fin=new FileInputStream(file);
	  XSSFWorkbook wb=new XSSFWorkbook(fin);
	  XSSFSheet sheet=wb.getSheet("userdata");
	
	  int rows=wb.getSheet("userdata").getPhysicalNumberOfRows();
	  System.out.println("Number of rows: "+rows);//6
	  
	  int cells=wb.getSheet("userdata").getRow(0).getPhysicalNumberOfCells();
	  System.out.println("Number of columns: "+cells);
	  
	   Object data[][]=new Object[rows-1][cells];//reading only 5 rows
	   
	    for(int i=1;i<rows;i++)
	  {
		  
		  for(int j=0;j<cells;j++)
		  {
			  
			  data[i-1][j]=wb.getSheet("userdata").getRow(i).getCell(j).getStringCellValue();
			  System.out.print(data[i-1][j]+"  ");
		  }
		  System.out.println();
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
}
