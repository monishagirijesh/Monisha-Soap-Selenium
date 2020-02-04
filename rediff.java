import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class rediff {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\\\TR soft\\\\Selenium Jars\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Rediffmail");
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.className("LC20lb")).click();
		
		//driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		//driver.findElement(By.name("login")).sendKeys("mmgckm@rediffmail.com");
		
		driver.findElement(By.id("login1")).sendKeys("mmgckm@rediffmail.com");
		driver.findElement(By.name("passwd")).sendKeys("mmgckm");
		driver.findElement(By.name("proceed")).click();
		driver.quit();
	}

}
