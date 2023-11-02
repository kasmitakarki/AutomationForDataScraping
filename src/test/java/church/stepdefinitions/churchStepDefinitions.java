package church.stepdefinitions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.gson.Gson;

import church.Global.churchCommon;
import church.datamodel.ChurchModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class churchStepDefinitions extends churchCommon
{
	public churchStepDefinitions() {
		super();
	}
	
	@Given("User opens website")
	public void user_opens_website() {
		openbroser();
	}

	@When("User verifies title")
	public void user_verifies_title() {
		verifyTitle("Upward Sports");
	}

	@When("User clicks Find a place to play")
	public void user_clicks_find_a_place_to_play() 
	{
	    clickElement("linkText", "FIND A PLACE TO PLAY");
	}

	@When("User enters {string}")
	public void user_enters(String zip) throws InterruptedException {
		//get window handle-current browser unique id
				String whndle= driver.getWindowHandle();
				
				//get all driver window handles opened using Driver
				Set<String> HNDLS= driver.getWindowHandles();
				
				//print all browser window handles
				
				for(String val : HNDLS)
				{
					System.out.println(val);
				}
				
				//iterator------------------
				
				Iterator <String> IT= HNDLS.iterator();
				String HNDL1= IT.next();
				String HNDL2= IT.next();
				
				//switch to window tab
				driver.switchTo().window(HNDL2); 
	    Thread.sleep(4000);
	    System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@class='form-control']")).click();
	    driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("20109");
	}

	@When("User selects first sport")
	public void user_selects_first_sport() {
	    WebElement sport= driver.findElement(By.xpath( "//select[@class='form-control']"));
	    Select s= new Select(sport);
	    s.selectByValue("basketball");
	}

	@When("User selects {int} Miles in the Radius Dropdown Box")
	public void user_selects_miles_in_the_radius_dropdown_box(Integer int1) {
		clickElement("xpath", "//select[@class='form-control']//option[contains(text(),'50')]");
	}

	@When("User clicks Go button")
	public void user_clicks_go_button() {
	    clickElement("className", "btn-text");
	}
	
	@When("User waits for some time")
	public void user_waits_for_some_time() throws InterruptedException {
	    Thread.sleep(4000);
	}

	@Then("User verifies result")
	public void user_verifies_result() {
	    int rc= driver.findElements(By.xpath("//ul[@class='list-group partner-list']//a[contains(text(),'View Details')]")).size();
	    System.out.println(rc);
	    System.out.println(driver.getTitle());
	    
	}
	
	@Then("User collects data and records it")
	public void user_collects_data_and_records_it() throws InterruptedException {
		int rc= driver.findElements(By.xpath("//ul[@class='list-group partner-list']//a[contains(text(),'View Details')]")).size();
	   
		List<ChurchModel> datalist= new ArrayList();
		
		for(int i=1;i<rc;i++) 
	    {
	    	//click view details
	    	clickElement("xpath", "/html/body/div/main/div/div/div[2]/ul/a["+i+"]/a");
	    	
	    	Thread.sleep(2000);
	    	
	    	//location and contact details
			WebElement church=driver.findElement(By.cssSelector("body > div > main > div > div > div.col-md-auto.partner-aside.px-3.py-4.transparent-dark-background.font-weight-bold > h5"));
			System.out.println(church.getText());
			String churchName= church.getText();
			
			
		
			
			WebElement address=driver.findElement(By.cssSelector("body > div > main > div > div > div.col-md-auto.partner-aside.px-3.py-4.transparent-dark-background.font-weight-bold > p:nth-child(2)"));
			System.out.println(address.getText());
			String churchAddress=address.getText();
			
			WebElement contact=driver.findElement(By.cssSelector("body > div > main > div > div > div.col-md-auto.partner-aside.px-3.py-4.transparent-dark-background.font-weight-bold > p:nth-child(4)"));
			System.out.println(contact.getText());
			String churchContact=contact.getText();
			
			
			//play information
			
			System.out.println("=======================");
			
			WebElement gameName=driver.findElement(By.cssSelector("body > div > main > div > div > div.col-md.flex-grow-1.transparent-primary-background.p-4 > div:nth-child(2) > div > div > p.league-list-item-title.text-primary.mb-1"));
			System.out.println(gameName.getText());
			String churchGameName= gameName.getText();
			
			WebElement details=driver.findElement(By.cssSelector("body > div > main > div > div > div.col-md.flex-grow-1.transparent-primary-background.p-4 > div.league-list.row.mt-3 > div > div > p:nth-child(2)"));
			System.out.println(details.getText());  
			String GameDetails= details.getText();
			
			//click previous program
			System.out.println("==========================");
			WebElement prevplay = null;
				try {
					prevplay= driver.findElement(By.xpath("//a[text()=' View Previous Programs ']"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			 
			if(prevplay==null) {
				//click return to search
				clickElement("xpath", "//a[text()='Return to Search']");
				
			}else {
				
				
				clickElement("xpath", "//a[text()=' View Previous Programs ']");
				
				//previous program information
				System.out.println("Previous play");
				WebElement prevPlayName=driver.findElement(By.cssSelector("body > div > main > div > div > div.col-md.flex-grow-1.transparent-primary-background.p-4 > div:nth-child(6) > div > div > p.league-list-item-title.text-primary.mb-1"));
				System.out.println(prevPlayName.getText());
				String churchPrevPlay= prevPlayName.getText();
				
				WebElement prevDetails=driver.findElement(By.cssSelector("body > div > main > div > div > div.col-md.flex-grow-1.transparent-primary-background.p-4 > div:nth-child(6) > div > div > p:nth-child(2)"));
				System.out.println(prevDetails.getText());
				String churchPrevDetails= prevDetails.getText();
				
				
				
				//click return to search
				clickElement("xpath", "//a[text()='Return to Search']");
				
				//data list
				ChurchModel c= new ChurchModel();
				c.setChurchName(churchName);
				c.setChurchAddress(churchAddress);
				c.setChurchContact(churchContact);
				c.setChurchGameName(churchGameName);
				c.setGameDetails(GameDetails);
				c.setChurchPrevPlay(churchPrevPlay);
				c.setChurchPrevDetails(churchPrevDetails);
				
				datalist.add(c);
				
				// Convert the object to JSON
		        Gson gson = new Gson();
		        String jsonString = gson.toJson(datalist);
		        
		        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output-4.json"))) {
		        	writer.write(jsonString);
		        	
		        }catch (IOException e) {
		        	e.printStackTrace();
		        	}
				
				
//				try (BufferedWriter writer = new BufferedWriter(new FileWriter("output-3.txt",true))) {
//					writer.newLine();
//					writer.write(churchName);
//					writer.newLine();
//		            writer.write(churchAddress);
//		            writer.newLine();
//		            writer.write(churchContact);
//		            writer.newLine();
//		            writer.write(churchGameName);
//		            writer.newLine();
//		            writer.write(GameDetails);
//		            writer.newLine();
//		            writer.write(churchPrevPlay);
//		            writer.newLine();
//		            writer.write(churchPrevDetails);
//		            writer.newLine();
//		            
//		            
//		            System.out.println("Data has been written to the file successfully.");
//		        } catch (IOException e) {
//		            e.printStackTrace();
//		        }
			}
			
			
			
	    }
	    
	}


	@Then("User closes browser")
	public void user_closes_browser() {
	    driver.close();
	    driver.quit();
	}
}
