import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class jquerry {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\\\TR soft\\\\Selenium Jars\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(35,TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable//");
		//String st=driver.findElement(By.id("draggable")).getText();
		//System.out.println(st);
		Thread.sleep(1000);
	//	driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		Thread.sleep(1000);
		WebElement src=driver.findElement(By.id("draggable"));
		WebElement dst=driver.findElement(By.id("droppable"));
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dst).build().perform();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.quit();
	}

}
