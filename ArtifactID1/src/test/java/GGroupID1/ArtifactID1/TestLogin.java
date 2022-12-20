package GGroupID1.ArtifactID1;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestLogin {
	WebDriver driver;

	@Test
	public void CheckLOgin() {

		String URL = "https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=100";
		driver = InvokingBrowser.invokingBowser("C", URL);
		LoginPage ABC = PageFactory.initElements(driver, LoginPage.class);
		ABC.LoginFB("Aniket", "Aniket");

	}

	
	public void ErrorMassage() {
		String URL = "https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=100";
		driver = InvokingBrowser.invokingBowser("E", URL);
		LoginPage ABC = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertNotEquals(ABC.GetErrorMassage(), "No search results");
	}

	
	public void validateloginErrormassage() {
		String URL = "https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=100";
		driver = InvokingBrowser.invokingBowser("C", URL);
		LoginPage ABC = PageFactory.initElements(driver, LoginPage.class);
		String S = ABC.LoginFBAndClick("Aniket", "Aniket");
		Assert.assertNotEquals(S, "No search results");
	}

	@AfterTest
	public void closeBrowser() {
//		LoginPage ABC = PageFactory.initElements(driver, LoginPage.class);		
//		ABC.quitBrowser();
		LoginPage A = new LoginPage(driver);
		A.quitBrowser();
	}
}
