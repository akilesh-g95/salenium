package FiledTrackingApplication;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginApplication {
	WebDriver driver;

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test(priority = 1)
	public void LoginAppwithvalidcredentials() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("https://field-tracking-dev.empmonitor.com/admin/login");
		driver.findElement(By.xpath("//div[@class=\"relative w-full pb-8\"]/input[@placeholder=\"Email Address\"]"))
				.sendKeys("Track2024@blondmail.com");
		driver.findElement(By.xpath("//div[@class=\"relative w-full pb-8\"]/input[@placeholder=\"Password\"]"))
				.sendKeys("@Mahantesh123");
		driver.findElement(By.xpath("//button[text()=\"Login\"]")).click();
		String ExpectedMessage = driver.findElement(By.xpath("//div[text()=\"Logged in successfully.\"]")).getText();
		Assert.assertEquals("Logged in successfully.", ExpectedMessage);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class=\"sidebar-icon mobile-setting-icon\"]")).click();
		Thread.sleep(3000);

		WebElement sliderbutt = driver.findElement(By.xpath("//span[@role=\"slider\"]"));

		WebElement sliderbar = driver
				.findElement(By.xpath("//div[@class=\"grid grid-cols-2 w-full gap-5\"]/following-sibling::div"));
		highlightElement(driver, sliderbar);
		Actions action = new Actions(driver);
		double xoffset = 395;
		action.dragAndDropBy(sliderbutt, (int) xoffset, 0).build().perform();
		Thread.sleep(3000);

		Boolean state = false;
		try {
		String ExpecetdRange = driver.findElement(By.xpath("//*[text()=\"Current Range\"]//span")).getText();
		Assert.assertEquals(50, ExpecetdRange);
		}catch(NoSuchElementException e) {
			Assert.assertEquals(true, state);
		}
		
		driver.findElement(By.xpath("//*[text()=\"Submit\"]")).click();
		Thread.sleep(4000);

		String expectedsubmit = "//div[text()=\"Location Details Updated Successfully\"]";

		String actulsubmit = driver.findElement(By.xpath("//div[text()=\"Location Details Updated Successfully\"]"))
				.getText();
		Assert.assertEquals(actulsubmit, expectedsubmit);
		
	}

	public static void highlightElement(WebDriver driver, WebElement element) {
		// Cast the driver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Store the original style of the element
		String originalStyle = element.getDomAttribute("style");

		// Apply a highlight style (e.g., red border and yellow background)
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red; background-color: yellow;');",
				element);

		// Wait for a short time to see the highlight (optional)
		try {
			Thread.sleep(6000); // 1 second delay
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Revert the element's style back to the original
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
	}

}
