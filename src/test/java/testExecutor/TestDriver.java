package testExecutor;

import tests.ProductListPageTest;

public class TestDriver {

	static String browser = "chrome";

	public static void main(String[] args) {

		// Run as Java Application
		ProductListPageTest productListPageTest = new ProductListPageTest();
		productListPageTest.T01_verifyProductList(browser); // calling test method

	}

}
