package TestData;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Logindataprovider {
public XSSFWorkbook wb;
	
	@Test
	@DataProvider(name="exceldata")
	public Object[][] testData()
	{
		 //path of file
		  File f1=new File("E:\\\\Nilima_SeleniumDemos\\\\HRMScenario1\\\\Excelfile\\\\logindata1.xlsx");
		  
		  //read in stream
		  FileInputStream fs;
		try {
			fs = new FileInputStream(f1);
			  //wb-->sheet-->row--->cell--->data
			  wb=new XSSFWorkbook(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
		  
		  //number of rows
		  int rows=wb.getSheet("userdata").getPhysicalNumberOfRows();
		  System.out.println("Number of rows: "+rows);//6
		  
		  //number of cells
		  int cells=wb.getSheet("userdata").getRow(0).getPhysicalNumberOfCells();
		  System.out.println("Number of columns: "+cells);
		  
		  //create an array of same size like file
		  Object data[][]=new Object[rows-1][cells];//reading only 5 rows
		  
		  
		  //iterate array read data from file and save it in array
		  
		  for(int i=1;i<rows;i++)
		  {
			  
			  for(int j=0;j<cells;j++)
			  {
				  //array always start with 0 index
				  data[i-1][j]=wb.getSheet("userdata").getRow(i).getCell(j).getStringCellValue();
				  //System.out.print(data[i-1][j]+"  ");
			  }
			  System.out.println();
		  }
		  
		  
		  return data;
	}


}
