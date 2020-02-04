import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;
public class xls {
	public static int xlRows,xlCols;
	public static String[][] xlData;
	public static String vSearch;
	

	public static void main(String[] args) throws Exception {
		
xlRead ("D:\\Monisha\\Google.xls");
		
		for(int i=1;i<xlRows;i++)
		{
			if(xlData[i][1].equalsIgnoreCase("y"))
				
			{
				
		    vSearch=xlData[i][0];
			
		    System.setProperty("webdriver.chrome.driver","D:\\TR soft\\Selenium Jars\\chromedriver.exe");
		    WebDriver driver=new ChromeDriver();
		    driver.get("https://google.com");
		    driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys(vSearch);
		    Thread.sleep(4000);
        
		    driver.findElement(By.xpath("//*[@name='btnK']")).click();
		    Thread.sleep(4000);
		    System.out.println(driver.getTitle());
		    xlData[i][3]=driver.getTitle();
		    Thread.sleep(4000);
	    TakesScreenshot src=(TakesScreenshot)driver;
	    	File pas=src.getScreenshotAs(OutputType.FILE);
	    	Files.copy(pas, new File("D:\\screenshots"+i+".png"));
	    	Thread.sleep(4000);
		    if(xlData[i][2].equalsIgnoreCase(xlData[i][3]))
		    {
		    	xlData[i][4]="Pass";
		    	
		    }
		    else 
		    {
		    	xlData[i][4]="Fail";
		    	
		    }
		    
        xlData[i][5]=("D:\\screeshos"+i+".png");
		    xlwrite("D:\\GoogleRes.xls",xlData);
        
		    driver.close();
			}
        	}

			}
			
		
        
	
	public static void xlRead(String sPath) throws Exception
	{
			File myFile=new File(sPath);
			FileInputStream myStream=new FileInputStream(myFile);
			HSSFWorkbook myworkbook=new HSSFWorkbook(myStream);
			HSSFSheet mySheet=myworkbook.getSheetAt(0);
			xlRows=mySheet.getLastRowNum()+1;
			xlCols=mySheet.getRow(0).getLastCellNum();
			xlData=new String[xlRows][xlCols];
			for(int i=0;i<xlRows;i++)
			{
				HSSFRow row=mySheet.getRow(i);
				for(short j=0;j<xlCols;j++)
				{
					HSSFCell cell=row.getCell(j);
					String value=cellToString(cell);
					xlData[i][j]=value;
					System.out.print("-"+xlData[i][j]);
				}
				System.out.println();
			}
	}
	public static String cellToString(HSSFCell cell)
	{
				int type=cell.getCellType();
				Object result;
				switch(type)
				{
				case HSSFCell.CELL_TYPE_NUMERIC:
				result=cell.getNumericCellValue();
				break;
				case HSSFCell.CELL_TYPE_STRING:
				result=cell.getStringCellValue();
				break;
				case HSSFCell.CELL_TYPE_FORMULA:
				throw new RuntimeException("We cannot evaluate formula");
				case HSSFCell.CELL_TYPE_BLANK:
				result="-";
				case HSSFCell.CELL_TYPE_BOOLEAN:
				result=cell.getBooleanCellValue();
				case HSSFCell.CELL_TYPE_ERROR:
				result="This cell has some error";
				default:
				throw new RuntimeException("We do not support this cell type");
				}
				return result.toString();
				
	}

	public static void xlwrite(String xlpath1,String[][] xData) throws Exception
			{
				System.out.println("Inside XL Write");
				File myFile1=new File(xlpath1);
				FileOutputStream fout=new FileOutputStream(myFile1);
				HSSFWorkbook wb=new HSSFWorkbook();
				HSSFSheet mySheet1=wb.createSheet("TestResults");
				for(int i=0;i<xlRows;i++)
				{
					HSSFRow row1=mySheet1.createRow(i);
					for(short j=0;j<xlCols;j++)
					{
						HSSFCell cell1=row1.createCell(j);
						cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell1.setCellValue(xData[i][j]);
					}
				}
				wb.write(fout);
				fout.flush();
				fout.close();
			}

}
	