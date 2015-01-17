package page

import geb.Page
import module.GoogleSearchModule

class GoogleResultsPage extends Page {
	static url = "https://www.google.com/?gws_rd=ssl"
	static at = { title.endsWith "Google Search" }
	static content = {
		// reuse our previously defined module
		search{ module GoogleSearchModule, buttonName: "btnG" }
		resultLinks(wait:true){ $("li" , class:"g")}
		firstResultLink(wait:true){ $("li" , class:"g" , 0).$("a")}
	}
	//firstResultLinkClickを追加
	public void firstResultLinkClick(){
		firstResultLink.click()
	}

	public void search(String keyword){
		try {
			search.field.value(keyword)
			search.button.click()
		} catch (Exception e) {
		}
	}
}
