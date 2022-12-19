package GGroupID1.ArtifactID1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		}
	
	@FindBy(xpath="//input[contains(@autocomplete,'username')]")WebElement userName;
	@FindBy(xpath="//input[@type='password']")WebElement password;
	@FindBy(how=How.LINK_TEXT,using="Forgotten account?")WebElement clickOnForgetPassword;
	@FindBy(how=How.ID,using="did_submit")WebElement clickOnserch;	
	@FindBy(how=How.CSS,using="[class=\"_9o4g fsl fwb fcb\"]")WebElement getErrorMessage;
	@FindBy(how=How.CSS,using="[value=\"1\"]:nth-of-type(1)")WebElement ClickOnLogin;
	@FindBy(how=How.CSS,using="[class=\"_9ay7\"]")WebElement getErrorMassageAtLogin;
	@FindBy(how=How.ID,using="identify_email")WebElement SendId;
	
	public void LoginFB(String id , String Pass) {		
		userName.sendKeys(id);
		password.sendKeys(Pass);
		clickOnForgetPassword.click();
	}
	public String LoginFBAndClick(String id , String Pass) {		
		userName.sendKeys(id);
		password.sendKeys(Pass);
		ClickOnLogin.click();
		WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(10L));
		wait.until(ExpectedConditions.visibilityOf(getErrorMassageAtLogin));
		return getErrorMassageAtLogin.getText();
	}
	
	public String GetErrorMassage() { 
		clickOnForgetPassword.click();
		SendId.sendKeys("AAAA");
		clickOnserch.click();
		String S ="AAA";
		return S;//getErrorMessage.getText().toString();		
	}
	public  void quitBrowser() {
		driver.quit();
	}
	
}