package page

import geb.Page
import module.GoogleSearchModule

class GoogleHomePage extends Page {

	// pages can define their location, either absolutely or relative to a base
	static url = "http://google.com/ncr"

	// “at checkers” allow verifying that the browser is at the expected page
	static at = { title == "Google" }

	static content = {
		// include the previously defined module
		search{ module GoogleSearchModule, buttonName: "btnG" }
	}

	public void search(String keyword){
		try {
			search.field.value(keyword)
			search.button.click()
		} catch (Exception e) {
		}
	}
}