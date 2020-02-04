import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Fossil {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\\\TR soft\\\\Selenium Jars\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Fossil watch for men");
		driver.findElement(By.xpath("//*[contains(@id,'twotabs')]")).sendKeys("puma shoe for women");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		//driver.findElement(By.className("nav-input")).click();
		driver.findElement(By.xpath("//*[text()='Fossil']")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'Gen 5')])")).click();
		
		
		Thread.sleep(3000);
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		
		driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
		Thread.sleep(1000);
		
		driver.quit();
		
		
		
		
		
	}

}
