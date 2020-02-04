import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class moni {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\\\TR soft\\\\Selenium Jars\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("software certification");
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).click();
		
		driver.findElement(By.className("LC20lb")).click();
		driver.findElement(By.xpath("//nav[@id='site-nav']/ul/li[4]/a")).click();

	}

}
