import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class slk 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\\\TR soft\\\\Selenium Jars\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("facebook.com");
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).click();
		
		driver.findElement(By.className("LC20lb")).click();
		driver.findElement(By.xpath("//*[@class='inputtext login_form_input_box']")).sendKeys("misha.vroon@gmail.com");
		
	
	
	}

}
