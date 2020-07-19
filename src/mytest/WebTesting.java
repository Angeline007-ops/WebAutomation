package mytest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class WebTesting {
	WebDriver driver;
	public void registrationAndLogin() {
	 System.setProperty("webdriver.gecko.driver","D:\\firefox\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true); 
		driver = new FirefoxDriver(capabilities); 
	    driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email_create")).sendKeys("test9782@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String genderValue= "2"; 		  
		List<WebElement> button = driver.findElements(By.name("id_gender"));  		  
		for (int i = 0; i < button.size(); i++)
		{
		   String getValue = button.get(i).getAttribute("value");
		   if (getValue.equalsIgnoreCase((genderValue)))
		   {
		    button.get(i).click();
		    break;
		   }		   
		 }
		 driver.findElement(By.id("customer_firstname")).sendKeys("Angel");
		 driver.findElement(By.id("customer_lastname")).sendKeys("Aish");
		 driver.findElement(By.id("passwd")).sendKeys("admin8796");
		 driver.findElement(By.id("days")).sendKeys("24");
		 driver.findElement(By.id("months")).sendKeys("April");
		 driver.findElement(By.id("years")).sendKeys("1999");
		 driver.findElement(By.id("address1")).sendKeys("Postbox Landmark");
		 driver.findElement(By.id("city")).sendKeys("Chennai");		
		 Select sState = new Select(driver.findElement(By.xpath("//*[@id='id_state']")));
		 sState.selectByVisibleText("Alabama");		 
		 driver.findElement(By.id("postcode")).sendKeys("00000");
		 driver.findElement(By.id("other")).sendKeys("890593589358935");
		 driver.findElement(By.id("phone_mobile")).sendKeys("6780989097");
		 driver.findElement(By.id("alias")).sendKeys("Norway");
		 driver.findElement(By.id("submitAccount")).click();
		 System.out.println("---Registration Successful!!!!---");
		 driver.findElement(By.className("logout")).click(); 	  
		 driver.findElement(By.className("login")).click();
		 //checks for invalid logins
		 try
			{
			 WebElement email = driver.findElement(By.id("email"));			 
			 WebElement password = driver.findElement(By.id("passwd"));
			 WebElement button1 = driver.findElement(By.id("SubmitLogin"));
			 email.sendKeys("angeerror123@gmail.com");
			 password.sendKeys("adminpasswd");
			 button1.click();
			 String exceptedURl = driver.getCurrentUrl();
			 System.out.println("Login Failure");
			
			 if(exceptedURl.contains("http://automationpractice.com/index.php?controller=my-account"))
			  {
			 System.out.println("Successful login");
			  }
			 else
			  {
				 //driver.switchTo().alert().accept();
			 System.out.println("Login Failure\nEmail and password are wrong!!");
			  }
					 
			  }
			catch(Throwable e)
			 {		      		  
			  System.out.println("Element: "+e.getMessage());
			 }
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("passwd")).clear();
		//checks for valid authentication 
			try 
			{
				
				WebElement emailid =  driver.findElement(By.id("email")); 
				WebElement password =	driver.findElement(By.id("passwd"));
				WebElement button2 = driver.findElement(By.id("SubmitLogin"));
			    emailid.sendKeys("angelineaishwarya.20it@licet.ac.in");
				password.sendKeys("admin123"); 
				button2.click();	
				System.out.println("---It is a vaid user login---");
				    String   exceptedURL1 = driver.getCurrentUrl();
				 
				    if(exceptedURL1.contains("http://automationpractice.com/index.php?controller=my-account")) 
					  {
						 System.out.println("login successful");
					  }
					 else 
					 {
						 System.out.println("Fail to login");
					 }			
				
			}
			catch(Throwable e)
			{		      		  
			  System.out.println("Element "+e.getMessage());
			}		
		
}

@Test
public void searchItem() 
{
	driver.findElement(By.name("search_query")).sendKeys("dress");
	WebElement search = driver.findElement(By.name("submit_search"));
	search.click();
	System.out.println("The item is searched!!");   		
	WebElement add = driver.findElement(By.xpath("//img[@src=\"http://automationpractice.com/img/p/1/2/12-home_default.jpg\"]"));
	add.click();
	WebElement addCart = driver.findElement(By.name("Submit"));
	addCart.click();
	System.out.println("Product successfully added to your cart!!");  	  		
		  		 
}



}


	

