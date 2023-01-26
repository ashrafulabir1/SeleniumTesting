import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class SeleniumTesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String website = "https://www.daraz.com.bd/";
		WebDriver driver = new ChromeDriver(); 
		driver.get(website);
		Thread.sleep(6000);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@id='q']")).sendKeys("mouse");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'SEARCH')]")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		
	    String serchButtonBackgroundColorLine =driver.findElement(By.xpath("//button[contains(text(),'SEARCH')]")).getCssValue("background");
	    String [] rgbaColor=serchButtonBackgroundColorLine.split(" url");
	    System.out.println(rgbaColor[0]);
	    String convertRgbToHexa = Color.fromString(rgbaColor[0]).asHex(); //website actual color
	    String expectedColor = "#f57224";
	    if(convertRgbToHexa.equals(expectedColor)) {
	    	System.out.println("The color is okay");
	    }
	    else {
	    	System.out.println("This color is not okay");
	    }
		Thread.sleep(10000);
		driver.quit();
	}
}
