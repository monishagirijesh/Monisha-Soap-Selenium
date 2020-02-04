

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class proj2 
{
	static String Expense;
	static String Income;
	static int i;

	static WebDriver driver;

	static String[] food = {"100","200","300"};
	static String[]clothing= {"10","20","30"};
	static String[]shelter= {"50","75","100"};
	static String[]Pay= {"10","20","30"};
	static String []Mother= {"10","20","30"};



	public void run() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver" ,"D:\\\\\\\\TR soft\\\\\\\\Selenium Jars\\\\\\\\chromedriver.exe");
		driver=new ChromeDriver();



		driver.get("http://www.youcandealwithit.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"siteNav\"]/li[1]/a"))).build().perform();
		driver.findElement(By.xpath("//*[@id=\"siteNav\"]/li[1]/ul/li[5]/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.className("calculatorsLink")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/ul/li[3]/a")).click();
		Thread.sleep(2000);
     }





	public void array() throws Exception 
	{	  
		for(i=0;i<3;i++)
	{
		driver.findElement(By.id("food")).sendKeys(food[i]);
		Thread.sleep(2000);
		driver.findElement(By.id("clothing")).sendKeys(clothing[i]);
		Thread.sleep(2000);
		driver.findElement(By.id("shelter")).sendKeys(shelter[i]);
		Thread.sleep(2000);



		driver.findElement(By.id("monthlyPay")).sendKeys(Pay[i]);
		Thread.sleep(2000);
		driver.findElement(By.id("monthlyOther")).sendKeys(Mother[i]);
		Thread.sleep(2000);

		//jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");

		Expense=driver.findElement(By.id("totalMonthlyExpenses")).getAttribute("value");
		System.out.println("Expense is:"+Expense);

		Income=driver.findElement(By.xpath("//*[@id=\"totalMonthlyIncome\"]")).getAttribute("value");
		System.out.println("Income is:"+Income);

		Float A=Float.parseFloat(Income);

		Float B=Float.parseFloat(Expense);

		if(A>B)
		{
			System.out.println("You are warren Buffet");
		}
		else if(A<B)
		{
			System.out.println("You are poor");
		}
		else
		{
			System.out.println("Nothing to show");
		}

		System.out.println("\n");

		driver.findElement(By.className("reset")).click();
		//Thread.sleep(2000);
	}
	

	}


	public void close() throws Exception 
	{
		Thread.sleep(2000);
		driver.close();
    
	}

}


