package handson;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		/*do
		{
		WebElement table=driver.findElement(By.id("example"));
		//it creates empty array when use find elements, it throws error when we use element
		List<WebElement> rows = table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
		for(WebElement row:rows)
		{
			System.out.print(row.findElements(By.tagName("td")).get(1).getText()+"\t");
			System.out.print(row.findElements(By.tagName("td")).get(5).getText());
			System.out.println();
		}
		}while(driver.findElements(By.cssSelector(".paginate_button.next.disabled")).size()==0);*/	
		
		while(driver.findElements(By.cssSelector(".paginate_button.next.disabled")).size()==0)
		{
			WebElement table=driver.findElement(By.id("example"));
			//it creates empty array when use find elements, it throws error when we use element
			List<WebElement> rows = table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
			for(WebElement row:rows)
			{
				int salary = Integer.parseInt(row.findElements(By.tagName("td")).get(5).getText().replaceAll("[$,]", ""));
				if(salary>300000)
				{
				System.out.print(row.findElements(By.tagName("td")).get(1).getText()+"\t");
				System.out.print(row.findElements(By.tagName("td")).get(5).getText());
				System.out.println();
				}
			}	
		driver.findElement(By.linkText("Next")).click();
	}
	WebElement table= driver.findElement(By.id("example"));
	//it creates empty array when use find elements, it throws error when we use element
	List<WebElement> rows = table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
	for(WebElement row:rows)
	{
		int salary = Integer.parseInt(row.findElements(By.tagName("td")).get(5).getText().replaceAll("[$,]", ""));
		if(salary>300000)
		{
			row.findElements(By.tagName("td")).get(0).click();
		System.out.print(row.findElements(By.tagName("td")).get(1).getText()+"\t");
		System.out.print(row.findElements(By.tagName("td")).get(5).getText());
		System.out.println();
		}
	}
}
}



