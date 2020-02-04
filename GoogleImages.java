import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleImages 
{
	public static void main(String[] args) throws InterruptedException

	{
		System.setProperty("webdriver.chrome.driver", "D:\\\\TR soft\\\\Selenium Jars\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	
		driver.findElement(By.name("q")).sendKeys("Testing");
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.linkText("Images")).click();
		
		Thread.sleep(1000);
	    driver.findElement(By.partialLinkText("Automated Testing or Test Automation ...")).click();
	
	    Thread.sleep(1000);
		driver.quit();
		
	}

}
