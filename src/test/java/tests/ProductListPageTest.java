package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseTest;
import pageClass.HomePage;

public class ProductListPageTest extends BaseTest {

	WebDriver driver;
	String url = "https://www.amazon.in/";
	String productListQuery = "SELECT * FROM ProductList";
	String productNameColumn = "ProductName";

	// Test Method
	public void T01_verifyProductList(String browser) {

		driver = setDriver(browser);
		HomePage homePage = new HomePage(driver);

		// PageFactory is used to find elements with @FindBy specified
		PageFactory.initElements(driver, homePage);

		homePage.launchApplication(url);
		homePage.setSearchText("Iphone14");
		homePage.clickSubmitButton();

		// this method verify the list of Product Name
		homePage.verifySearchResultProductList(productListQuery, productNameColumn);

		homePage.sleep(5000);
		homePage.quitDriver();

	}

}
