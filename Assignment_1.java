package selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment_1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shri\\Desktop\\Testing class\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		
		//1.Launch the website https://www.flipkart.com/
		driver.get("https://www.Flipkart.com");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
        driver.findElement(By.xpath("//button[text()=\"✕\"]")).click();
		
        //a.Hover on Fashion section.
	     WebElement ele=driver.findElement(By.xpath("//div[text()=\"Fashion\"]"));
	     Actions act=new Actions(driver);
	     
	     act.moveToElement(ele).perform();
	     
	    //b.Hover on the Kids subsection and click on "Boys & Girls Jeans".
	     WebElement ele1=driver.findElement(By.xpath("//a[text()=\"Kids\"]"));
	     act.moveToElement(ele1).perform();
	     
	     WebElement ele2=driver.findElement(By.xpath("//a[text()=\"Boys & Girls Jeans\"]"));
	     act.click(ele2).perform();
	    
        //c.Select the Price-Low to High in the Sort By section
	     WebElement ele3=driver.findElement(By.xpath("//div[text()=\"Price -- Low to High\"]"));
	     act.click(ele3).perform();
	    
	     //d.Click on any items displayed.
	     WebElement ele4=driver.findElement(By.xpath("//a[@title=\"Baby Boys Slim Mid Rise Blue Jeans\"]"));
	     act.click(ele4).perform();
	      
	    //e.Get the price of the item and name of the item.
	     System.out.println(ele4.getText());
	
        WebElement ele5= driver.findElement(By.xpath(" //div[@class=\"_30jeq3 _16Jk6d\"]"));
        String price=ele5.getText();
        System.out.println(price);
	     
        //f.Fill all the required fields and add the item to the cart.
	    
	     driver.findElement(By.xpath("//input[@class=\"cfnctZ\"]")).sendKeys("12345");
	     driver.findElement(By.xpath("//div[text()=\"YELLOWBOY \"]")).click();
	     driver.findElement(By.xpath("//a[text()=\"6 - 12 Months\"]")).click();
	     driver.findElement(By.xpath("//span[text()=\"Size Chart\"]")).click();
	     driver.findElement(By.xpath("//button[text()=\"Add to cart\"]")).click();
	     
	     //g.Verify the price and name of the item in the checkout page matches with the one we had before added the item
	    
	     String actual= driver.findElement(By.xpath("//a[@title=\"Baby Boys Slim Mid Rise Blue Jeans\"]")).getText();
	     String excepted ="Baby Boys Slim Mid Rise Blue Jeans";
	     
	     if(actual.equalsIgnoreCase(excepted))
	     {
	    	 System.out.println("Test case passed");
	     }
	     else
	     {
	    	 System.out.println("Test case failed");
	     }

	     //2.Navigate to https://demoqa.com/nestedframes and get the text “Child Iframe” and print it on the console
           
	       driver.navigate().to("https://demoqa.com/nestedframes");
		 
		   driver.switchTo().frame("frame1").switchTo().frame(0);
		   String Text= driver.findElement(By.tagName("p")).getText();
		   System.out.println(Text);
		 
		   driver.switchTo().defaultContent();

        // 3.Navigate to https://demoqa.com/alerts and handle all the 4 alerts present with the “Click me” button
		   
		    driver.navigate().to("https://demoqa.com/alerts");
			 
			driver.findElement(By.id("alertButton")).click();
			Alert alt = driver.switchTo().alert();
			alt.accept();
            driver.findElement(By.id("timerAlertButton")).click();
			

			Alert alt1 = driver.switchTo().alert();
			alt1.accept();

			driver.findElement(By.id("confirmButton")).click();
			Alert alt2 = driver.switchTo().alert();
			alt2.accept();

			driver.findElement(By.id("promtButton")).click();
			Alert alt3 = driver.switchTo().alert();
			alt3.accept();
     
			//4.Navigate to https://demoqa.com/droppable and Click on “Accept” tab. Drop “Not Acceptable” and dop in the “Drop here” box
			
			 
			 driver.navigate().to("https://demoqa.com/droppable");
			 Thread.sleep(1000);
			 driver.findElement(By.id("droppableExample-tab-accept")).click();
			 Actions act1= new Actions(driver); 
			 WebElement source = driver.findElement(By.id("notAcceptable")); 
			 WebElement target = driver.findElement(By.id("droppable")); 
			 Thread.sleep(1000);  
			 act.clickAndHold(source).moveToElement(target).release().build().perform(); act.dragAndDrop(source, target).perform();

          
			 //5.Navigate to https://demoqa.com/browser-windows and Click on “New Window” and verify the text in the new window and close it.
			 
			    driver.navigate().to("https://demoqa.com/browser-windows");
				driver.findElement(By.xpath("//button[text()=\"New Window\"]")).click();
				String parentid=driver.getWindowHandle();
				System.out.println(parentid);
				Set<String> childid=driver.getWindowHandles();
				System.out.println(childid);

				for(String s:childid)
				{
					System.out.println(s);
					if(!s.equals(parentid))
					{
						driver.switchTo().window(s);
						System.out.println(driver.findElement(By.xpath("//h1[@id=\"sampleHeading\"]")).getText());
					 driver.close();
					}
				}
	}

}
