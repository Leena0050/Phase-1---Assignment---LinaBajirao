package commonClass;

import org.openqa.selenium.WebDriver;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

//	This method will launchApplication & accept url as String
	public void launchApplication(String url) {
		try {
			driver.get(url);
			System.out.println("URL: " + url + " launched successfully ");
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			System.out.println("URL: " + url + " launched failed ");
		}
	}

//	This method will quit the driver instance
	public void quitDriver() {
		try {
			driver.quit();
			System.out.println("Webdriver quit successfully ");
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			System.out.println("Webdriver quit failed ");
		}
	}
}
