package com.apollo2.apollo2_Homepage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IITM_Homepage {
private RemoteWebDriver driver;
	
	@BeforeTest
	
	public void setup() throws MalformedURLException
	{
		  DesiredCapabilities dc = DesiredCapabilities.chrome();
	        URL url = new URL("http://172.20.23.92:4444/wd/hub");
	        driver = new RemoteWebDriver(url, dc);
	       
	}

    @Test(priority=1)
    public void testSanity() throws InterruptedException {
    	driver.get("https://iitm.humanbrain.in/index.html");
        driver.manage().window().maximize();
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentURL);
    	 //driver.switchTo().frame(0);
        
    }
    @Test(priority=2)

   public void homepagecontent()
   		{
	   
	   String heading1="Sudha Gopalakrishnan Brain Centre";
	   WebElement text1=driver.findElement(By.xpath("//h1[@class='head']"));
	   String Heading1 =text1.getText();
	   System.out.println("Head1:"+Heading1);
	   Assert.assertEquals(Heading1, heading1, "Heading1 are not equal");
	   
	   String heading2="Indian Institute of Technology Madras";
	   WebElement text2=driver.findElement(By.xpath("(//h1[@class='head']//following::h5)[1]"));
	   String Heading2 =text2.getText();
	   System.out.println("Head2:"+Heading2);
	   Assert.assertEquals(Heading2, heading2, "Heading2 are not equal");
	   
	   String expectedText = "The Sudha Gopalakrishnan Brain Centre of IIT Madras operates a world-class high-throughput multimodal whole-brain histology-imaging-compute pipeline, to digitize and study human brains at unprecedented high-resolution and scale. The centre leverages expertise across IITM, national, and international collaborations, and aims to become a globally leading R&D centre for human brain research with transformative impact in neuroscience and neurotechnologies.";

	   WebElement paragraphElement = driver.findElement(By.xpath("//p[@class='footer-data text-justify']"));
	   String actualText = paragraphElement.getText();
	   System.out.println("Extracted Text: " + actualText);

	   // Validating the extracted text
	   Assert.assertEquals(actualText, expectedText, "Extracted text does not match the expected text");
	   String expectedText1 = "DHARANI: A 3D Developing Human-brain Atlas Resource to Advance Neuroscience Internationally";
	   String expectedUrl = "https://brainportal.humanbrain.in";

	   // Locate the anchor element using XPath
	   String expectedText11 = "DHARANI: A 3D Developing Human-brain Atlas Resource to Advance Neuroscience Internationally";
	    String expectedUrl1 = "https://brainportal.humanbrain.in";

	    // Locate the anchor element using XPath
	    WebElement linkElement = driver.findElement(By.xpath("//a[@class='blinker-link']"));

	    // Extract the text of the link
	    String actualText1 = linkElement.getText();
	    System.out.println("Link Text: " + actualText1);

	    // Extract the href attribute of the link
	    String actualUrl = linkElement.getAttribute("href").trim();
	    System.out.println("Link URL: " + actualUrl);

	    // Normalize the URL (remove trailing slash if necessary)
	    if (actualUrl.endsWith("/")) {
	        actualUrl = actualUrl.substring(0, actualUrl.length() - 1);
	    }

	    // Validate the text of the link
	    Assert.assertEquals(actualText1, expectedText11, "Link text does not match the expected text");

	    // Validate the href attribute of the link
	    Assert.assertEquals(actualUrl, expectedUrl1, "Link URL does not match the expected URL");

	    System.out.println("Link validation is successful!");
	
		   System.out.println("Homepage  content validation is done");
   }
    @Test(priority=3)

    public void homepagePeople() throws InterruptedException {

		  driver.findElement(By.xpath("(//a[text()='PEOPLE'])[1]")).click();
		  
		  driver.findElement(By.xpath("//button[text()='Chair Professors']")).click();
		  scroll();
		 
		  driver.findElement(By.xpath("//button[text()='Faculty']")).click();
		  scroll();
		  
		  driver.findElement(By.xpath("//button[text()='Collaborators']")).click();
		  scroll();
		  
		  driver.findElement(By.xpath("//button[text()='Researchers']")).click();
		  scroll();
		 
		  driver.findElement(By.xpath("//button[text()='Software Team']")).click();
		  scroll();
		  
		  driver.findElement(By.xpath("//button[text()='Analytics Team']")).click();
		  scroll();
		 
		  driver.findElement(By.xpath("//button[text()='Engineering Team']")).click();
		  scroll();
	
		  driver.findElement(By.xpath("//button[text()='Optics & Imaging Team']")).click();
		  scroll();
		  
		  driver.findElement(By.xpath("//button[text()='Wet Lab Team']")).click();
		  scroll();
		  driver.findElement(By.xpath("//button[text()='Internship']")).click();
		  scroll();
		  
		  System.out.println("Homepage people validation is done");

    }
    @Test(priority=4)
    public void homepagehighlights() throws InterruptedException
    {
    	 driver.findElement(By.xpath("(//a[text()='HIGHLIGHTS'])[1]")).click();
		  scroll();
		 driver.findElement(By.xpath("//button[text()='Computational']")).click();
		  scroll();
		 
		  
		 driver.findElement(By.xpath("//button[text()='Technology']")).click();
		  scroll();
		 
		  System.out.println("Homepage Highlights validation is done");
    	 
    }

    @Test(priority=5)
    public void homepagepublications() throws InterruptedException
    {
    	
    	 driver.findElement(By.xpath("(//a[text()='PUBLICATIONS'])[1]")).click();
		  scroll();
    	 driver.findElement(By.xpath("//button[text()='2024']")).click();
    	 driver.findElement(By.xpath("//button[text()='2023']")).click();
    	 driver.findElement(By.xpath("//button[text()='2022']")).click();
    	
    	 driver.findElement(By.xpath("(//p[@class='pubTitle'])[20]")).click();
    	    	 
    }
    
       
    @Test(priority=6)

    public void Homenewsandevents() throws InterruptedException {
  	  driver.findElement(By.xpath("(//a[text()='NEWS & EVENTS'])[1]")).click();
  	  scroll();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//button[text()='2024']")).click();
		  scroll();
	    	 driver.findElement(By.xpath("//button[text()='2023']")).click();
	    	 scroll();
	    	 driver.findElement(By.xpath("//button[text()='2022']")).click();
	    	 scroll();
		  
		  System.out.println("Homepage News and Events validation is done ");
  }
    @Test(priority=7)

    public void Homecontacts() throws InterruptedException  {

		 driver.findElement(By.xpath("(//a[text()='CONTACTS'])[1]")).click();
		 scroll();
		 driver.switchTo().frame(0);
		 driver.findElement(By.xpath("(//input[@name='Name'])[1]")).sendKeys("software");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@name='Name'])[2]")).sendKeys("Team");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("softwareteam@htic.iitm.ac.in");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@id='PhoneNumber']")).sendKeys("9516765121");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//textarea[@id='MultiLine-arialabel']")).sendKeys("Testing purpose" );
		 Thread.sleep(1000);
		// driver.findElement(By.xpath("(//button[@value='submit'])[1]")).click();
		// Thread.sleep(2000);
		// WebElement submitmessage=driver.findElement(By.xpath("//span[@class='alignCenter infoCont thankyouMsgText']"));
		// String Sumbitmessage=submitmessage.getText();
		// System.out.println("Submitted message is = "+Sumbitmessage);
		// System.out.println("Homepage contacts validation is done ");
		  
  }
   
    private void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    private void scrollToTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
    }
    private void scroll() throws InterruptedException
    {
    	Thread.sleep(2000);
    	scrollToBottom(driver);
        Thread.sleep(2000);
        scrollToTop(driver);
        Thread.sleep(2000);
    }
    private void windowhandle()  throws InterruptedException 
    {
    	String parentWindowHandle = driver.getWindowHandle();
   	    Set<String> windowHandles = driver.getWindowHandles();
           for (String windowHandle : windowHandles) {
   	    driver.switchTo().window(windowHandle);
   	    
   	    }
           Thread.sleep(2000);
           driver.close();
           Thread.sleep(2000);
           driver.switchTo().window(parentWindowHandle);
          //driver.switchTo().frame(0);
    }

    @AfterClass
    public void close() {
        
            driver.quit();
        
    }
}
