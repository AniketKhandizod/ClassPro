package GGroupID1.ArtifactID1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ScreenShot_Compare {

	public static void CoparingSS() throws IOException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/Image");
		WebElement img = driver.findElement(By.xpath("(//img[@class='thumbimage'])[1]"));

		Screenshot capture = new AShot().takeScreenshot(driver, img);
		BufferedImage ActualImg = capture.getImage();

		BufferedImage I = ImageIO.read(new File(
				"C:\\Users\\anike\\git\\ClassPro\\ArtifactID1\\src\\test\\java\\GGroupID1\\ArtifactID1\\AA.png"));
		// BufferedImage I = ImageIO.read(new File
		// ("C:\\Users\\anike\\Desktop\\Laugh.png"));

		ImageDiffer ID = new ImageDiffer();
		ImageDiff diff = ID.makeDiff(ActualImg, I);

		System.out.println(diff.hasDiff());
		try {
			driver.quit();
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	public static void CoparingSS1() throws IOException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/Image");
		WebElement logoImage = driver.findElement(By.xpath("(//img[@class='thumbimage'])[1]"));

		BufferedImage expectedImage = ImageIO
				.read(new File(System.getProperty("user.dir") + "\\src\\test\\java\\GGroupID1\\ArtifactID1\\AA.png"));
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImage);
		BufferedImage actualImage = logoImageScreenshot.getImage();
		BufferedImage I = ImageIO.read(new File("C:\\Users\\anike\\Desktop\\Laugh.png"));

		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(I, expectedImage);
		System.out.println(diff.hasDiff());

		driver.quit();
	}

	public static void imageComaparision() throws IOException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");

		WebElement logoImage = driver.findElement(By.cssSelector("#imagetrgt"));

		BufferedImage expectedImage = ImageIO
				.read(new File("C:\\Users\\anike\\Desktop\\A.png"));
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImage);
		BufferedImage actualImage = logoImageScreenshot.getImage();
		BufferedImage I = ImageIO.read(new File("C:\\Users\\anike\\Desktop\\MyPic.jpeg"));

		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(I, expectedImage);
		System.out.println(diff.hasDiff());

		driver.quit();
	}

	public static void main(String[] args) throws IOException {

		// CoparingSS() ;
	//	CoparingSS1();
		imageComaparision();
	}

}
