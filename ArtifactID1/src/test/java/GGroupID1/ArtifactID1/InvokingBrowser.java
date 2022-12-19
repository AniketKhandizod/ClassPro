package GGroupID1.ArtifactID1;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokingBrowser {

	static WebDriver driver ;
	public static WebDriver invokingBowser(String browser ,String URL) {
		
		if (browser.equals("E")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equals("C")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("F")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}		 
	    driver.manage().window().setSize(new Dimension(1000,1000));		
		driver.manage().window().setPosition(new Point (50,50));
		driver.get(URL);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
		return driver;
			
	}
}
