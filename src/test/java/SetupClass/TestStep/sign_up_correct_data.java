package SetupClass.TestStep;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Dimension;

import SetupClass.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class sign_up_correct_data extends Set {
	
	WebDriverWait wait = new WebDriverWait(driver,50);
	
       JavascriptExecutor js = (JavascriptExecutor) driver;
	

	@Given("^user is already on sign up page cd$")
	public void user_is_already_on_sign_up_page_cd() throws InterruptedException  {
	    
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
	    Thread.sleep(2000);
	    try {
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
			if (logout.isEnabled()) {
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}
	    Thread.sleep(3000);
		try {
			driver.findElement(By.cssSelector("ul.header > li:nth-child(1) > a:nth-child(1)")).click();
			Thread.sleep(2000);
			log.info("It's opening the website URL and redirect user to sign up page");
		} 
		catch (NoSuchElementException popup) {
		}
	}

	@Then("^enter new email to sign up cd$")
	public void enter_new_email_to_sign_up_cd() throws InterruptedException  {
	    
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    System.out.println(generatedString);
	    
	    String signup_email=generatedString;
	    String full_email="selenium.testing."+generatedString+"@gmail.com";
	    System.out.println(full_email);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		//driver.findElement(By.id("email_address")).sendKeys(full_email);
		

		Thread.sleep(2000);
	    WebElement new_email_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("email_address")));
		Thread.sleep(2000);
	    new_email_signup.sendKeys(full_email);
		Thread.sleep(2000);
	}

	@Then("^User enter firstname and lastname to sign up cd$")
	public void user_enter_firstname_and_lastname_to_sign_up_cd() throws InterruptedException  {
	    

	    WebElement new_fname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("firstname")));
		Thread.sleep(2000);
	    new_fname_signup.sendKeys("Selenium");
		Thread.sleep(2000);

	    WebElement new_lname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("lastname")));
		Thread.sleep(2000);
	    new_lname_signup.sendKeys("Testing");
		Thread.sleep(2000);
	}

	@Then("^user enter password and confirm password to sign up cd$")
	public void user_enter_password_and_confirm_password_to_sign_up_cd() throws InterruptedException  {
	    
		 WebElement new_pwd_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
			Thread.sleep(2000);
		    new_pwd_signup.sendKeys("selenium@123");
			Thread.sleep(2000);

		    WebElement new_pwd1_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("password-confirmation")));
			Thread.sleep(2000);
		    new_pwd1_signup.sendKeys("selenium@123");
			Thread.sleep(2000);
	}

	@Then("^user enter captcha to sign up cd$")
	public void user_enter_captcha_to_sign_up_cd() throws InterruptedException  {
	    
		WebElement new_captcha_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("captcha_user_create")));
		Thread.sleep(2000);
	    new_captcha_signup.sendKeys("Aj7W2mtf9namwf55");
		
	}

	@Then("^check checkbox to sign up cd$")
	public void check_checkbox_to_sign_up_cd() throws InterruptedException  {
	    
		/*
		 * WebElement new_checkbox_signup =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
		 * ".iCheck-helper"))); Thread.sleep(2000); new_checkbox_signup.click();
		 */
		Thread.sleep(2000);
	}

	@Then("^user click on sign up button to sign up cd$")
	public void user_click_on_sign_up_button_to_sign_up_cd() throws InterruptedException  {
	    
		WebElement new_btn_signup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".submit")));
		Thread.sleep(2000);
	    new_btn_signup.click();
		Thread.sleep(2000);
	   
	}

	@Then("^user lands on pricing page and then user go to free ppts page cd$")
	public void user_lands_on_pricing_page_and_then_user_go_to_free_ppts_page_cd() throws InterruptedException  {
		
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement free_ppt_btn1=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Free Stuff")));
		actions.moveToElement(free_ppt_btn1).moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Free PPTs')]"))).click().build().perform();
		Thread.sleep(7000);
		//WebElement free_ppt_btn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/header/div[1]/div[2]/div/nav/div/div/ul/li[2]/div/ul/li[1]/a")));
	    //free_ppt_btn.click();
	    //Thread.sleep(2000);
		
		  /* String searchimage = "document.querySelector(\"[class='.small_image_hover']\")".getSize();;
		   js.executeScript(searchimage);
		Thread.sleep(4000);
	        driver.get("https://www.slideteam.net/professional-powerpoint-templates");
		Thread.sleep(5000);
		String searchimage1 =  "document.querySelector(\"[class='.small_image_hover']\")".getSize();;
                js.executeScript(searchimage1);
                Thread.sleep(2000);*/
		
		
		
		var myImg = document.querySelector("//[class='.small_image_hover']");
		
		alert("Product found");
		 var currWidth = myImg.clientWidth;
        var currHeight = myImg.clientHeight;
        alert("Current width=" + currWidth + ", " + "Current height=" + currHeight);
          Thread.sleep(2000);
		
		driver.get("https://www.slideteam.net/professional-powerpoint-templates");
		Thread.sleep(5000);
		var myImg1 = document.querySelector("//[class='.small_image_hover']");
		 var currWidth1 = myImg1.clientWidth;
        var currHeight1 = myImg1.clientHeight;
        alert("Current width=" + currWidth1 + ", " + "Current height=" + currHeight1);

		
		//Dimension size = searchimage
		  //System.out.println(size);
		
		//WebElement size=driver.findElement(By.className("small_image_hover"));
                //   int width=driver.findElement(By.tagName("img")).getSize().getWidth();
                //  int height=driver.findElement(By.tagName("img")).getSize().getHeight();

                //  System.out.println(width +">>>"+height);
                  
      //to verify width
     // Assert.assertEquals(width, 152);
      //to verify height
     // Assert.assertEquals(height, 62);
		////Dimension Size1 = searchimage1.getSize();
		//System.out.println(Size1);
               // Thread.sleep(4000);
		
		//WebElement size0=driver.findElement(By.className("small_image_hover"));
     // int height1=driver.findElement(By.tagName("img")).getSize().getHeight();
           // System.out.println(width1 +">>>"+height1);
		
      //to verify width
    //  Assert.assertEquals(width1, 152);
      //to verify height
     // Assert.assertEquals(height1, 62);
	}

	@Then("^user download a free product cd$")
	public void user_download_a_free_product_cd() throws InterruptedException  {
		
	}

	@Then("^user delete the new account created cd$")
	public void user_delete_the_new_account_created_cd() throws InterruptedException  {
       Thread.sleep(3000);

		
		 WebElement account = driver.findElement(By.xpath("//a[contains(.,'My Account')]"));
			  Thread.sleep(3000);
			account.click();
		 Thread.sleep(3000);
		 
		

		 WebElement delete_account = driver.findElement(By.cssSelector("#clicking"));
		js.executeScript("arguments[0].scrollIntoView();",delete_account);
		 delete_account.click();
		 Thread.sleep(3000);
		WebElement delete_reason = driver.findElement(By.cssSelector("#exampleRadios1"));
		Thread.sleep(3000);
		delete_reason.click();
		Thread.sleep(3000);
		
		 WebElement delete_profile = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#delete-final")));
		js.executeScript("arguments[0].scrollIntoView();",delete_profile);
		delete_profile.click();
		 Thread.sleep(3000);
		
		WebElement delete_profile_coupon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#flipModal > div > div > div.modal-footer.button_action > button.btn.btn-default.button_2")));
		js.executeScript("arguments[0].scrollIntoView();",delete_profile_coupon);
		delete_profile_coupon.click();
		 Thread.sleep(3000);
	}
	
	
}
