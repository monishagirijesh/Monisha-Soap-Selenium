import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class google
{
	public static void main(String[] args) throws InterruptedException

	{
		System.setProperty("webdriver.chrome.driver", "D:\\\\TR soft\\\\Selenium Jars\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
     	String mg="meaning of name monisha";
		
		driver.findElement(By.name("q")).sendKeys(mg);
		//String mg=driver.findElement(By.name("q")).getAttribute("value");
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).click();
		
		String mmg=driver.findElement(By.id("resultStats")).getText();
		System.out.println(mmg);
		Thread.sleep(1000);
		
		String mp =driver.findElement(By.name("q")).getAttribute("value");
		
		if(mg.equals(mp))
		{
			System.out.println("Assertion true");
			
		}
		else
		{
			System.out.println("Assertion False");
		}
		
		driver.quit();
	
	}	
}
