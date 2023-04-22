package pageClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import commonClass.BasePage;
import dev.failsafe.internal.util.Assert;
import pageObjects.HomePageObjects;
import utilities.DataBaseConnection;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = HomePageObjects.TXT_SEARCH_BOX)
	WebElement txtSearch;

	@FindBy(how = How.ID, using = HomePageObjects.BTN_SUBMIT)
	WebElement btnSubmit;

	@FindBys(@FindBy(xpath = HomePageObjects.HDG_PRODUCTS))
	List<WebElement> txtProductList;

	/*
	 * this method is used to setText in search box
	 */
	public void setSearchText(String text) {
		txtSearch.sendKeys(text);
	}

	/*
	 * this method is used to click submit button
	 */
	public void clickSubmitButton() {
		btnSubmit.click();
	}

	/*
	 * this method is used to assert list of product name
	 */
	public void verifyWithAssertSearchResultProductList(String query, String columnName) {

		System.out.println("Number of Products in Search Result: " + txtProductList.size());
		ResultSet result = DataBaseConnection.setConnection(query);
		for (int i = 0; i < txtProductList.size(); i++) {
			try {

				result.next();
				System.out.println("Actual : " + txtProductList.get(i).getText());
				System.out.println("Expected : " + result.getString(columnName));

				Assert.isTrue(result.getString(columnName).equals(txtProductList.get(i).getText()),
						"Product " + i + " didn't match");

				System.out.println(columnName + " " + (i + 1) + " Matched Successfully ");
				System.out.println("*********");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * this method is used to compare list of product name
	 */
	public void verifySearchResultProductList(String query, String columnName) {

		System.out.println("Number of Products in Search Result: " + txtProductList.size());
		ResultSet result = DataBaseConnection.setConnection(query);
		for (int i = 0; i < txtProductList.size(); i++) {
			try {

				result.next();
				System.out.println("Actual : " + txtProductList.get(i).getText());
				System.out.println("Expected : " + result.getString(columnName));

				if (txtProductList.get(i).getText().equals(result.getString(columnName))) {
					System.out.println(columnName + " " + (i + 1) + " Matched ");
				} else {
					System.out.println(columnName + " " + (i + 1) + " Not Matched ");
				}

				System.out.println("*********");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * this method is used to hold execution for provided time in millisecond as
	 * parameter
	 */
	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
