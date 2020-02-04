import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class gmail {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\\\TR soft\\\\Selenium Jars\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com/");
		
		driver.findElement(By.linkText("Help")).click();
		Thread.sleep(1000);
		myprt(driver.getTitle());
		
		//to point the pointer to child window with window handler
		
		Set<String> id=driver.getWindowHandles();
		Iterator<String> it=id.iterator();
		String parent=it.next();
		String child=it.next();
		
		
		driver.switchTo().window(child);
		myprt(driver.getTitle());
		driver.findElement(By.linkText("Community")).click();
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(parent);
		myprt(driver.getTitle());
		driver.close();
		
	}
	public static void myprt(String str)
	{
		System.out.println(str);
		System.out.println("");
	}

}
