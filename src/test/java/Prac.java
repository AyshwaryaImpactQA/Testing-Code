import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by : Mayank Bansal
 * Prac.java
 * Oct 12, 2017
 * Purpose : Description details
 */

/**
 * @author mayank.bansal
 *
 */
public class Prac {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mayank.bansal.IMPACTQA\\git\\NC-Sanity-automation-codeK\\src\\test\\resources\\Drivers\\Windows\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.google.com");
		driver.navigate().to("https://nccloud.teachermatch.org");
		
		
		// TODO Auto-generated method stub

	}

}
