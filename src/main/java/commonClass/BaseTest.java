package commonClass;

import org.openqa.selenium.WebDriver;

import utilities.ManageDriver;

public class BaseTest {

//	This method will launchApplication & accept url as String
	public static WebDriver setDriver(String browser) {

		ManageDriver manageDriver = new ManageDriver();
		try {
			return manageDriver.setDriver(browser);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
