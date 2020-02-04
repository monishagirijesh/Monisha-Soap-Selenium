import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class alertandsynchronization {
	public static void main(String[] args) throws InterruptedException 

{

	System.setProperty("webdriver.chrome.driver", "D:\\\\TR soft\\\\Selenium Jars\\\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://demo.automationtesting.in/Alerts.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
	
	driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
	driver.switchTo().alert().dismiss();

	WebDriverWait wait =new WebDriverWait(driver,5);	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")));
	//driver.findElement(By.linkText("Alert with Textbox ")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
	driver.switchTo().alert().sendKeys("Kaneez");
	driver.switchTo().alert().accept();
	Thread.sleep(5000);
driver.quit();	
}
}