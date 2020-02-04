import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebook 
{public static void main(String[] args) throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "D:\\\\TR soft\\\\Selenium Jars\\\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	driver.findElement(By.id("email")).sendKeys("misha.vroon@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("mishavroon");
	
	driver.findElement(By.linkText("Forgotten account?")).click();
	driver.findElement(By.partialLinkText("Data")).click();
	Thread.sleep(100);
	driver.close();
	driver.quit();
   
}


}
