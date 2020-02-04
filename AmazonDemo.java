import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonDemo 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\\\TR soft\\\\Selenium Jars\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Puma shoes for women");
		driver.findElement(By.className("nav-input")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/span[4]/div[1]/div[15]/div/span/div/div/span/a/div/img")).click();
		driver.findElement(By.xpath("//*[text()='return']")).click();
		//driver.findElement(By.linkText("Back to results")).click();
		//driver.findElement(By.xpath("//*[@id='wayfinding-breadcrumbs_feature_div']/ul/li[2]/span/a")).click();
		
		Thread.sleep(1000);
	   // driver.quit();
		
	
		
		
	}

}
